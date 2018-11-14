package com.asiainfo.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.asiainfo.util.DynamicDataSourceHolder;

public class DataSourceSwitcher extends AbstractRoutingDataSource{

	@Override
    protected Object determineCurrentLookupKey() { 
        return DynamicDataSourceHolder.getRouteKey();
    }
}
