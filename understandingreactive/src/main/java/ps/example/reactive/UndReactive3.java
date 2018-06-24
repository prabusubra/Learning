package ps.example.reactive;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class UndReactive3 {

	public static void main(String[] args) throws Exception {
		
		Executor exe = Executors.newCachedThreadPool();
		
		Flowable<String> flw1 = Flowable.just("un","deux","trois","quatre","sank","six","sept");
		
		//exe.execute(()->{
			Flowable.range(1, 500)
			.map(Alpha::new)
			.subscribeOn(Schedulers.io())
			.doOnSubscribe(onSubscribe -> {
				onSubscribe.request(10);
			})
			.subscribe(data -> {
				
				Thread.sleep(1000);
				System.out.println(" Received :: "+data.val);
			});
			
			Thread.sleep(Long.MAX_VALUE);
		//});

	}
	
	static class Alpha{
		private int val;
		public Alpha(int v) {
			this.val = v;
			System.out.println(" Building :: "+val);
		}
	}
}
