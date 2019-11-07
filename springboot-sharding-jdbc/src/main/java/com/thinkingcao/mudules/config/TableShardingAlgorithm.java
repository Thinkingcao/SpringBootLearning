package com.thinkingcao.mudules.config;

import java.util.Collection;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;

/**
 * <pre>
 * @author cao_wencao
 * @date 2018年12月11日 下午9:22:49
 * </pre>
 */
public class TableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<Long>{

	
	@Override
	public Collection<String> doBetweenSharding(Collection<String> arg0, ShardingValue<Long> arg1) {
		
		return null;
	}

	
	@Override
	public String doEqualSharding(Collection<String> arg0, ShardingValue<Long> arg1) {
		
		return null;
	}


	@Override
	public Collection<String> doInSharding(Collection<String> arg0, ShardingValue<Long> arg1) {
		
		return null;
	}

}
