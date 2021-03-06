import hello.beer.recommend.BeerRecommendServiceGrpc
import io.grpc.ServerBuilder
import io.grpc.protobuf.services.ProtoReflectionService

import scala.concurrent.{ExecutionContext, ExecutionContextExecutor}

object ServerMain {
  val executionContext: ExecutionContextExecutor = ExecutionContext.global
  val port = 50051

  def main(args: Array[String]) = {
    val server = ServerBuilder.forPort(port)
      .addService(BeerRecommendServiceGrpc.bindService(new DefaultBeerRecommendService, executionContext))
      .addService(ProtoReflectionService.newInstance())
      .build()
      .start()
      .awaitTermination()
  }

}
