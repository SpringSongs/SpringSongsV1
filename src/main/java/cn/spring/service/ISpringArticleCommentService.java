package cn.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.spring.domain.SpringComment;
import cn.spring.util.R;

public interface ISpringArticleCommentService {

	void deleteByPrimaryKey(String id);

	void insert(SpringComment record);

	SpringComment selectByPrimaryKey(String id);

	void updateByPrimaryKey(SpringComment record);

	Page<SpringComment> getAllRecordByPage(SpringComment record,Pageable pageable);

	void setDeleted(List<String> ids);
	
	R batchSaveExcel(List<String[]> list);
	
	void delete(List<String> ids);
}
