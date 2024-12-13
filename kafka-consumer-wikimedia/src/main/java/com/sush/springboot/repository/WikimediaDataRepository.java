package com.sush.springboot.repository;

import com.sush.springboot.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository  extends JpaRepository<WikimediaData,Long> {

}
