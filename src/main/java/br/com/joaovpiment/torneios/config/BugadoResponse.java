//package br.com.joaovpiment.torneios.config;
//
//public class BugadoResponse implements Response {
//
//	private final Response response;
//
//	public BugadoResponse(Response response) {
//		this.response = response;
//	}
//
//	@Override
//	public ResponseBody body() {
//		return response.body();
//	}
//
//	@Override
//	public String header(String name) {
//		if ("Content-Type".equals(name)) {
//			return "application/json"; // set the desired content type
//		}
//		return response.header(name);
//	}
//
//	@Override
//	public Map<String, Collection<String>> headers() {
//		return response.headers();
//	}
//
//	@Override
//	public Collection<String> headers(String name) {
//		return response.headers(name);
//	}
//
//	@Override
//	public String reason() {
//		return response.reason();
//	}
//
//	@Override
//	public int status() {
//		return response.status();
//	}
//}
//
//
//}
