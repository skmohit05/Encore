CREATE TABLE `lt_data` (
  `url` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` json NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `lt_data`
  ADD PRIMARY KEY (`url`);
COMMIT;

