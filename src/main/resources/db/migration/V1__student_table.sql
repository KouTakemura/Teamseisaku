CREATE TABLE student (
    id SERIAL NOT NULL COMMENT 'ID',
    studentnumber VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生番号',
    name VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '学生名',
    nyuugaku INT(10) COMMENT '入学年度',
    classnum CHAR(3) COMMENT 'クラス番号',
    zaigakuhuragu BOOLEAN COMMENT '在学中フラグ',
    schoolnumber CHAR(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '学校コード',
    PRIMARY KEY (studentnumber)
    
) ENGINE    =InnoDB;


