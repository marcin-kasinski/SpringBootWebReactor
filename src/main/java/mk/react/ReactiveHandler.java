package mk.react;
import java.util.concurrent.Callable;

import org.springframework.stereotype.Component;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import mk.WorkUnit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
@Component
public class ReactiveHandler {

	public Callable<WorkUnit> dosomething(WorkUnit wu) {
		
		String threadName=Thread.currentThread().getName() ;
    	System.out.println("threadName "+threadName);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Callable<WorkUnit>) wu;
	}
	
	public Mono<ServerResponse> home1(ServerRequest req) {
//		String id = req.pathVariable("id");
		
		WorkUnit wu= new WorkUnit("parentId","spanTraceId","id","definition");
    	wu.setDefinition("mkdefinition");
    	wu.setId("mkid");
    	wu.setParentId("mkparentId");
    	wu.setSpanTraceId("mkspanTraceId");

		//return ServerResponse.ok().body(Mono.just(wu).map(this::dosomething),
				return ServerResponse.ok().body(Mono.just(wu),
				WorkUnit.class);
	}

	public Mono<ServerResponse> home2(ServerRequest req) {
//		String id = req.pathVariable("id");
		
		WorkUnit wu= new WorkUnit("parentId","spanTraceId","id","definition");
    	wu.setDefinition("mkdefinition");
    	wu.setId("mkid");
    	wu.setParentId("mkparentId");
    	wu.setSpanTraceId("mkspanTraceId");

		return ServerResponse.ok().body(Mono.just(wu),
				WorkUnit.class);
	}

	public Mono<ServerResponse> home3(ServerRequest req) {
//		String id = req.pathVariable("id");
		
		WorkUnit wu= new WorkUnit("parentId","spanTraceId","id","definition");
    	wu.setDefinition("mkdefinition");
    	wu.setId("mkid");
    	wu.setParentId("mkparentId");
    	wu.setSpanTraceId("mkspanTraceId");

		return ServerResponse.ok().body(Mono.just(wu),
				WorkUnit.class);
	}

	public Mono<ServerResponse> home4(ServerRequest req) {
//		String id = req.pathVariable("id");
		
		WorkUnit wu= new WorkUnit("parentId","spanTraceId","id","definition");
    	wu.setDefinition("mkdefinition");
    	wu.setId("mkid");
    	wu.setParentId("mkparentId");
    	wu.setSpanTraceId("mkspanTraceId");

		return ServerResponse.ok().body(Mono.just(wu)
				.publishOn(Schedulers.elastic())
			//	.subscribe(v -> System.out.prinln(""))
				.subscribeOn(Schedulers.parallel())
				,
				WorkUnit.class);
	}

	public Mono<ServerResponse> home5(ServerRequest req) {
//		String id = req.pathVariable("id");
		
		WorkUnit wu= new WorkUnit("parentId","spanTraceId","id","definition");
    	wu.setDefinition("mkdefinition");
    	wu.setId("mkid");
    	wu.setParentId("mkparentId");
    	wu.setSpanTraceId("mkspanTraceId");
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ServerResponse.ok().body(Mono.just(wu)
				.publishOn(Schedulers.elastic())
			//	.subscribe(v -> System.out.prinln(""))
				.subscribeOn(Schedulers.elastic())
				,
				WorkUnit.class);
	}

	public Mono<ServerResponse> home6(ServerRequest req) {

    	 return Mono.fromCallable(() -> {
 	    	WorkUnit wu= new WorkUnit("parentId","spanTraceId","id","definition");
 	    	wu.setDefinition("mkdefinition");
 	    	wu.setId("mkid");
 	    	wu.setParentId("mkparentId");
 	    	wu.setSpanTraceId("mkspanTraceId");
 	    	String threadName=Thread.currentThread().getName() ;
 	    	System.out.println("threadName "+threadName);

 	        Thread.sleep(1000);
// 	        return ServerResponse.ok().body(Mono.just(wu), WorkUnit.class).first();
 	        return ServerResponse.ok().body(Mono.just(wu), WorkUnit.class).block();
 	        
 	        
 	    }).subscribeOn(Schedulers.elastic());    	 
	}



	public Mono<ServerResponse> findAll(ServerRequest req) {
		
		WorkUnit wu1= new WorkUnit("parentId1","spanTraceId1","id1","definition1");
		WorkUnit wu2= new WorkUnit("parentId2","spanTraceId2","id2","definition2");
		WorkUnit wu3= new WorkUnit("parentId3","spanTraceId3","id3","definition3");
		WorkUnit wu4= new WorkUnit("parentId4","spanTraceId4","id4","definition4");
		WorkUnit wu5= new WorkUnit("parentId5","spanTraceId5","id5","definition5");

		
		return ServerResponse.ok().body(
				Flux.just(wu1,wu2,wu3,wu4,wu5 ), WorkUnit.class);
}
}
