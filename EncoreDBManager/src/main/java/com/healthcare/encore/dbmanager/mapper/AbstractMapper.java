/**
 *
 */
package com.healthcare.encore.dbmanager.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ckumar
 * @param <D> DTO
 * @param <M> Model
 *
 */
public abstract class AbstractMapper<D, M> {

   /**
    *
    * @param dto
    * @return Model
    */
   public abstract M getModel(D dto);

   /**
    *
    * @param dtos
    * @return Model
    */
   public List<M> getModel(final List<D> dtos) {
      List<M> models = new ArrayList<M>();
      for (D dto : dtos) {
         models.add(this.getModel(dto));
      }
      return models;
   }
}
