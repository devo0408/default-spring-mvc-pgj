package com.devo.data;

import org.springframework.data.repository.CrudRepository;

public interface GlobalServerValueRepository extends CrudRepository<GlobalServerValue, Integer> {

    GlobalServerValue findByKey(String key);

}
