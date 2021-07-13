## ArrayBlockingQueue

定义:  
由数组结构组成的有界阻塞队列  

方法：  
>- add(E e)  
>   当队列未满时，添加元素成功  
>   当队列满时，方法抛出异常
>- remove()  
>   当队列不为空时，删除并返回队列的头元素  
>   当队列为空时，方法抛出异常
 
 
>- offer(E e)   
>   当队列未满时，添加元素成功，方法返回true  
>   当队列满时，方法返回false
>- poll()  
>   当队列不为空时，删除并返回队列的头元素  
>   当队列为空时，方法返回null


>- put(E e)   
>   当队列未满时，添加元素成功  
>   当队列满时，方法阻塞，直到元素被取走
>- take()  
>   当队列不为空时，删除并返回队列的头元素  
>   当队列为空时，方法阻塞，直到有新元素添加到队列中


>- offer(E e, long timeout, TimeUnit unit)  
>   当队列未满时，添加元素成功，方法返回true  
>   当队列满时，方法等待超时，如果指定时间未添加成功，则返回false
>- poll(long timeout, TimeUnit unit)  
>   当队列不为空时，删除并返回队列的头元素 
>   当队列为空时，方法等待超时，如果指定的时间未获取到元素，则返回null


## LinkedBlockingQueue
定义：  
由链表结构组成的有界（Integer.MAX_VALUE）阻塞队列

方法：  
同ArrayBlockingQueue

注意：  
LinkedBlockingQueue默认大小为Integer.MAX_VALUE，如果使用默认值，当心内存溢出

## SynchronousQueue
定义：
同步队列，不存储元素，相当于单元素的阻塞队列，按照put -> take -> put -> take 顺序执行