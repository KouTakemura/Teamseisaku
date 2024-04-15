package jp.ac.ohara.timeseisaku.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.ohara.timeseisaku.model.StudentHyou;
import jp.ac.ohara.timeseisaku.repository.StudentRepository;

	 

@Service
@Transactional
public class  StudentService{

    @Autowired
    private StudentRepository repository;


         
    /**
     *学生一覧の取得
     *@return List<Gakusei>
     **/
	 public List<StudentHyou> getStudentList() {
	    List<StudentHyou> entityList = this.repository.findAll();
	    return entityList;}

	    
	/**     
	* 詳細データの取得
	* @param @NonNull Long index
	  */
	 
	 public StudentHyou get(@NonNull Long index) {
	        StudentHyou student = this.repository.findById(index).orElse(new StudentHyou());
	        return student;
	    }

	    public void save(@NonNull StudentHyou student) {

	        this.repository.save(student);

	    }



	    /**
	     
	アドレス帳データの削除
	@param @NonNull Long index*/
	public void delete(@NonNull Long index) {
	    this.repository.deleteById(index);}
	// 受け取ったidからデータを取得して、Formを返却する
	  public StudentHyou getOneBook(Long id) {// idを指定して本の情報を取得する
	      StudentHyou student = this.repository.findById(id).orElseThrow();// 画面返却用のFormに値を設定する
	      return student;}

	    // 本を更新する
	    public void update(StudentHyou editstudent) {
	        // データベースに登録する値を保持するインスタンスの作成
	        System.out.println(editstudent);


	        // データベースを更新する
	        this.repository.save(editstudent);
	        System.out.println("aaa");
	    }
	}


