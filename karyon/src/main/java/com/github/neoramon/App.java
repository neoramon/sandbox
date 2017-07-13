package com.github.neoramon;

import com.github.neoramon.App.KaryonJerseyModuleImpl;
import com.netflix.governator.annotations.Modules;

import io.netty.buffer.ByteBuf;
import netflix.adminresources.resources.KaryonWebAdminModule;
import netflix.karyon.KaryonBootstrap;
import netflix.karyon.ShutdownModule;
import netflix.karyon.archaius.ArchaiusBootstrap;
import netflix.karyon.eureka.KaryonEurekaModule;
import netflix.karyon.servo.KaryonServoModule;
import netflix.karyon.transport.http.KaryonHttpModule;

@ArchaiusBootstrap
@KaryonBootstrap(name = "myapp", healthcheck = MyHealthCheck.class)
@Modules(include = { ShutdownModule.class, KaryonWebAdminModule.class, KaryonJerseyModuleImpl.class,
        KaryonServoModule.class, KaryonEurekaModule.class })
public interface App {

	class KaryonJerseyModuleImpl extends KaryonHttpModule<ByteBuf, ByteBuf> {

		protected KaryonJerseyModuleImpl() {
			super("KaryonHystrixJerseyModule", ByteBuf.class, ByteBuf.class);
		}

		@Override
		protected void configureServer() {
			bind(AuthenticationService.class).to(AuthenticationServiceImpl.class);
			bindRouter().to(JerseyHystrixBasedRouter.class);
			interceptorSupport().forUri("/*").intercept(LoggingInterceptor.class);
			interceptorSupport().forUri("/admin/*").interceptIn(AuthInterceptor.class);
			server().port(8889).threadPoolSize(10);
		}
	}
}
