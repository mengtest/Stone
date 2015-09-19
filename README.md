Stone
=====
a game server engine（
[**YO YO YO! Click me, biatch !**](https://github.com/crazyjohn/Stone/wiki)）




1. framework 
----------
- core。this is the most important part of the engine，almost the whole framework codes are at here。

- db。this is the data service layer，you can use this project to persistence you db object。

- proto。this is the proto between client and server，i use google's protobuf to support this。

- tools。do some tools things，for example generate the Template class。

- test。all the engine test cases are at here。

2. examle
----------
> when i have finished write 70 percent of the engine，i begin to write a example to prove this is a amazing engine。i choose to write a mmo game。

- bot。this is the robot framework，i use scala to write it, and it use for pressure test。by the way, i must say that scala is fucking amazing！

- agent。this is the external session manager server。

- game。this is the logic server。

- world。 this is the center server。


now, what's the progress?
----------
- you can create account, login, create role, select role and enter scene。



TODO
----------
- template engine: mabe i will use velocity。
- db human sub entity。
- data layer use cache。
- routing logic。
- balance。
- robot pressure test, and make the test doc。
- all the framework use akka，use remote and cluster。


cn
----------
1. 模板层的设计，使用velocity或者freemaker之类的模板引擎，还有一种方案就是用scala去定义DSL，然后使用DSL来做这个事情？

2. 数据层的详细设计，子实体？缓存？落地策略？

3. 路由逻辑，以及负载均衡

4. 多服架构的逻辑，Gate + Login + Game，如何实现透明化的scale out?可以参考pomelo和skynet

5. robot压测文档