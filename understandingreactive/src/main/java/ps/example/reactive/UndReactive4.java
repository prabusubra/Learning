package ps.example.reactive;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class UndReactive4 {
	
	static List<String> data = Arrays.asList("alpha","beta","gamma","delta","epsilon","zeta","eta","theta");
	
	public static void main(String[] a) {
		
		Observable<String> obs = Observable.create(source ->{
			data.forEach(action -> {
				if (source.isDisposed())
					return;
				source.onNext(action);
			});
			source.onComplete();
		});
		
		obs
		.doOnNext(d -> {
			System.out.println(d);
		})
		.subscribe();
	}

}
