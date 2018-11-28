package com.peng.rule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/**   
* 项目名称：microservicecloud-consumer-dept-80   
* 类名称：RandomRule_PK   
* 类描述：   通过轮循的方式，让一个微服务执行5次后，轮循到下一个微服务
* 创建人：彭坤   
* 创建时间：2018年11月28日 下午10:30:16      
* @version     
*/
public class RandomRule_PK extends AbstractLoadBalancerRule {
	
	//total=0 当total==5后，指针往下走
	//index=0当前对外提供服务的微服务
	//当total==5后total=0
	
	private int total=0;//当前微服务提供服务的次数
	private int index=0;//当前微服务
	
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {//当前线程是否中断
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            //核心开始
            if (total<5) {
				server = upList.get(index);
				total++;
			}else {
				total=0;
				index++;
				if (index>=upList.size()) {
					index=0;
				}
			}
            //核心结束
            

            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            server = null;
            Thread.yield();
        }

        return server;

    }

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		
	}
}
