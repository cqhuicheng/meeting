package com.cqhc.modules.system.repository;

import com.cqhc.modules.system.domain.MeetingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author huicheng
* @date 2019-04-24
*/
public interface MeetingInfoRepository extends JpaRepository<MeetingInfo, Long>, JpaSpecificationExecutor {
}