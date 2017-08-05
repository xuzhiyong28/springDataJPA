package com.springdatajpa.dao;/**
 * Created by Administrator on 2017/8/2.
 */

import com.springdatajpa.domain.LearnResource;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author xuzhiyong
 * @createDate 2017-08-02-14:50
 */
public interface LearnResourceRepository extends PagingAndSortingRepository<LearnResource,Long> {

}
