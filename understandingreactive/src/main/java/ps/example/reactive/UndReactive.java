package ps.example.reactive;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class UndReactive {

	public static void main(String[] args) throws Exception {
		
		Flowable<String> obs1 = Flowable.just("alpha", "beta", "gamma", "delta", "epsilon", "zeta", "eta", "theta", "iota", "kappa");
		
		Flowable<Long> obs2 = Flowable.interval(1, TimeUnit.SECONDS);
		//Observable<String> obs2 = Observable.just(" !!! ").repeat(10);
		
		//Flowable<String> obs3 = Flowable.just(" !!! ").repeat(10);
		Flowable<String> obs4 = Flowable.just("un", "deux", "trois", "quatre", "sank", "six", "sept", "huit", "neuf", "deese");
		
		Flowable.zip(obs1,obs2,(t1,t2)->
			{
				return t2+" -- "+t1+" -- "+Thread.currentThread().getName();
			})
		//.subscribeOn(Schedulers.newThread())
		.subscribe((data)->{
			System.out.println(data +" -- "+Thread.currentThread().getName());
		});
		
		obs4
		.map(mapper ->{
			if (mapper.equals("deux")) {
				Thread.sleep(1000);
				return mapper;
			}
			return mapper;
			
		})
		.subscribe((data)->{
			System.out.println(data +" -- "+Thread.currentThread().getName());
		});
		//obs2.subscribe((data)->
			//System.out.println(data));
		
		Thread.sleep(11000);
		
		//obs1.map(data ->{
			//if (data.equals("gamma"))
				//Thread.sleep(1000);
			//return data;
		//})
		//.subscribe(System.out::println);
		//System.out.println("out scope...");
		//obs4.subscribe(System.out::println);
		
//		Flowable.zip(obs1,obs3, (T1,T3)->
//		
//		{
//			return T1+T3;
//			
//		})
//		
//		/* Observable.merge(obs1, obs2)
//		.map(m->{
//			System.out.println("inside map -- "+m);
//			return m;
//			
//		})*/
//		
//		.subscribe(System.out::println,
//				(e)->{
//					e.printStackTrace();
//				},
//				()->{
//					System.out.println("Completed ...");
//				});
	}
		
	}