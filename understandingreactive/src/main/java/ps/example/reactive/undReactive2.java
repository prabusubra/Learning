package ps.example.reactive;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class undReactive2 {

	public static void main(String[] args) throws Exception {
		/*
		 * Cold Observables.
		 * Observables must issue notifications serially not in parallel.
		 * **/
//		
		Flowable<String> obs4 = Flowable.just("un", "deux", "trois", "quatre", "sank", "six", "sept", "huit", "neuf", "deese");
//		obs4.map(mapper -> {
//			if ("deux".equals(mapper))
//				Thread.sleep(2000);
//			return mapper+" -- "+Thread.currentThread().getName();
//		})	
//		.subscribe(System.out::println);
		
		Observer<String> observer1 = new Observer<String>() {

			@Override
			public void onComplete() {
				System.out.println("Completed...");
				
			}

			@Override
			public void onError(Throwable arg0) {
				arg0.printStackTrace();
				
			}

			
			@Override
			public void onSubscribe(Disposable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNext(String arg0) {
				System.out.println("on next -- "+arg0);
				
			}
		};
		
		List<String> list1 = Arrays.asList("un","deux","trois","quatre","sank");
		
		Observable obs5 = Observable.fromIterable(list1);
		
		//obs5.subscribe(observer1);
		
		//Flowable.range(3, 10).subscribe(System.out::println);
		
		new Thread(
		()->{
			obs4
			.map(mapper ->{
				if ("deux".equals(mapper) || "quatre".equals(mapper))
					Thread.sleep(2000);
				return mapper+" -- "+Thread.currentThread().getName();
			})
			.subscribe(System.out::println);
			
		}).start();
		
//		new Thread() {
//			public void run() {
//				obs4
//					.map(mapper ->{
//						if ("deux".equals(mapper) || "quatre".equals(mapper))
//							Thread.sleep(2000);
//						return mapper+" -- "+Thread.currentThread().getName();
//					})
//					.subscribe(System.out::println);
//			}
//		}.start();
		
//		Executor exe = Executors.newCachedThreadPool();
//		
//		exe.execute(()->{
//			
//			obs4
//			.map(mapper ->{
//				if ("deux".equals(mapper) || "quatre".equals(mapper))
//					Thread.sleep(2000);
//				return mapper+" -- "+Thread.currentThread().getName();
//			})
//			.subscribe(System.out::println);
			
//			obs4.subscribe();
//			Flowable.zip(obs4, Flowable.interval(2, TimeUnit.SECONDS),(k,v)->k)
//			.subscribe((data)->{
//				System.out.println(" "+data+" -- "+Thread.currentThread().getName());
//			});
//			Flowable.interval(1, TimeUnit.SECONDS)
//			.map(mapper -> {
//				if (mapper == 3)
//					throw new Exception(" Time is Over !!! ");
//				return mapper;
//			})
//			.subscribe((data)->{
//				System.out.println(data +" -- "+Thread.currentThread().getName());
//			},(e)->{
//				e.printStackTrace();
//			});
			
		//});
		
//		//Thread.sleep(5000);	
//		Flowable<String> flw1 = Flowable.just("un","deux","trois","quatre","sank","six","sept");
//		flw1
//		//.subscribeOn(Schedulers.from(Executors.newFixedThreadPool(4)))
//		.map(mapper ->{
//			if ("deux".equals(mapper))
//				Thread.sleep(1000);
//			if ("quatre".equals(mapper))
//				Thread.sleep(500);
//			return mapper +" -- "+Thread.currentThread().getName();
//		})
//		.subscribe(System.out::println);
//		
//		Thread.sleep(2000);
	}
}
