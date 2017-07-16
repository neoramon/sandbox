package com.github.neoramon;

import io.netty.buffer.ByteBuf;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import netflix.karyon.transport.interceptor.DuplexInterceptor;
import rx.Observable;

public class DuplexHystrixStream implements DuplexInterceptor<HttpServerRequest<ByteBuf>, HttpServerResponse<ByteBuf>> {

  @Override
  public Observable<Void> in(HttpServerRequest<ByteBuf> request, HttpServerResponse<ByteBuf> response) {
    return Observable.empty();
  }

  @Override
  public Observable<Void> out(HttpServerResponse<ByteBuf> response) {
    return Observable.empty();
  }

}
