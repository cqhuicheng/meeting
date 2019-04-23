package me.zhengjie.modules.system.service.query;

import me.zhengjie.utils.PageUtil;
import me.zhengjie.modules.system.domain.Unit;
import me.zhengjie.modules.system.service.dto.UnitDTO;
import me.zhengjie.modules.system.repository.UnitRepository;
import me.zhengjie.modules.system.service.mapper.UnitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jie
 * @date 2018-12-03
 */
@Service
@CacheConfig(cacheNames = "unit")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UnitQueryService {

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private UnitMapper unitMapper;

    /**
     * 分页
     */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(UnitDTO unit, Pageable pageable){
        Page<Unit> page = unitRepository.findAll(new Spec(unit),pageable);
        return PageUtil.toPage(page.map(unitMapper::toDto));
    }

    /**
    * 不分页
    */
    @Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(UnitDTO unit){
        return unitMapper.toDto(unitRepository.findAll(new Spec(unit)));
    }

    class Spec implements Specification<Unit> {

        private UnitDTO unit;

        public Spec(UnitDTO unit){
            this.unit = unit;
        }

        @Override
        public Predicate toPredicate(Root<Unit> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

            List<Predicate> list = new ArrayList<Predicate>();

                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
        }
    }
}