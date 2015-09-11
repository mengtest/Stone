package com.stone.core.node;

import java.util.HashMap;
import java.util.Map;

import com.stone.core.node.info.CommonServerInfo;
import com.stone.core.node.info.ISuperServerNode;

public class SuperServerNode extends ServerNode implements ISuperServerNode {
	protected Map<String, CommonServerInfo> masterServers = new HashMap<String, CommonServerInfo>();
	protected Map<String, CommonServerInfo> slaveServers = new HashMap<String, CommonServerInfo>();

	@Override
	public CommonServerInfo getSlaveServer(String serverName) {
		return slaveServers.get(serverName);
	}

	@Override
	public CommonServerInfo getMasterServerInfo(String serverName) {
		return masterServers.get(serverName);
	}

}
