package com.matuszew.data.common.mapper.tublelog;

import com.matuszew.data.common.model.bo.TumbleLog;
import com.matuszew.data.common.model.json.TumbleLogJson;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Created by matuszewski on 27/04/2017.
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RestTumbleLogMapper {

    RestTumbleLogMapper INSTANCE = Mappers.getMapper(RestTumbleLogMapper.class);

    TumbleLog map(TumbleLogJson tumbleLogJson);
}
