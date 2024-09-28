package com.healthcare.encore.db.dao.hibernate;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.healthcare.encore.db.dao.MedicalEmployerJobPostingDAO;
import com.healthcare.encore.db.dto.MedicalEmployerJobPostingDTO;
import com.healthcare.encore.db.dto.UserDTO;

/**
 *
 * @author mmeena
 *
 */
@Repository
public class MedicalEmployerJobPostingDAOImpl extends BaseDAOImpl<MedicalEmployerJobPostingDTO, Integer>
         implements MedicalEmployerJobPostingDAO {

   /**
    *
    */
   public MedicalEmployerJobPostingDAOImpl() {
      super(MedicalEmployerJobPostingDTO.class);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public List<MedicalEmployerJobPostingDTO> findAll(final UserDTO userDTO) {
      return super.list("MedicalEmployerJobPostingDTO.findAll", new String[] { "userId" }, userDTO.getId());
   }

   @Override
   public List<MedicalEmployerJobPostingDTO> findByJobSeach(final LocalDate date, final String title, final String speciality,
            final String location) {
      @SuppressWarnings("deprecation")
      Criteria cr = super.getCurrentSession().createCriteria(MedicalEmployerJobPostingDTO.class);
      if(date != null) {
         cr.add(Restrictions.ge("postedDate", date));
      }
      if(StringUtils.isNotBlank(title)) {
         cr.add(Restrictions.eq("title", title).ignoreCase());
      }
      if(StringUtils.isNotBlank(speciality)) {
         String specialityLike = "%" + speciality + "%";
         cr.add(Restrictions.ilike("speciality", specialityLike));
      }
      if(StringUtils.isNotBlank(location)) {
         cr.add(Restrictions.eq("state", location).ignoreCase());
      }
      return cr.list();
   }

}
