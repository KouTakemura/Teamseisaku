package jp.ac.ohara.timeseisaku.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;



@Data
@Entity
@Table(name="student")
public class StudentHyou {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column
        private long id;
        
        @Column(length = 10, nullable = false)
        private String studentnumber;
        
        @Column(length = 10, nullable = true)
        private String name;
	        
        @Column(length = 10, nullable = true)
        private Integer nyuugaku;
	        
        @Column(length = 3, nullable = true)
        private String classnum;
	        
        @Column(length = 1, nullable = true)
        private Boolean zaigakuhuragu;

        @Column(length = 3, nullable = true)
        private String schoolnumber;
}
	

