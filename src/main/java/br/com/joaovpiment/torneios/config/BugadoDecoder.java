//package br.com.joaovpiment.torneios.config;
//
//import java.io.IOException;
//import java.lang.reflect.Type;
//
//import feign.FeignException;
//import feign.Response;
//import feign.codec.DecodeException;
//import feign.codec.Decoder;
//
//public class BugadoDecoder implements Decoder {
//
//	private final Decoder decoder;
//
//	public BugadoDecoder(Decoder decoder) {
//		this.decoder = decoder;
//	}
//
//	@Override
//	public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
//		Response customResponse = new CustomResponse(response); // use the custom response implementation
//		return decoder.decode(customResponse, type);
//	}
//
//
//
//}
