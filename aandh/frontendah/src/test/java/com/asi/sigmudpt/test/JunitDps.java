package com.asi.sigmudpt.test;

public class JunitDps {

////	@Test
//	public void test() {
//		try {
//			Map<String, String> httpHeaderMap = new HashMap<>();
//			httpHeaderMap.put("Content-Type", "application/x-www-form-urlencoded");
//			httpHeaderMap.put("Authorization",
//					"Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE1NjY1MTA2MTAsImlhdCI6MTU2NjQ5MjYxMH0.dlt0SPaAAXJ-ncnd7Y8tPu24LDfROKwAzyaw3q_EFaJg5IGid7-L-kRlrYlTK1rSt2EXvEpP5eoVfEf33VE4XQ");
//
//			Map<String, String> conditionMap = new HashMap<>();
//
//			CommonAsi commonAsi = new CommonAsi();
//			String res = commonAsi.fetchPostMethodRestfulApisType2(
//					SpringBootProperty.getApisurlDpswarningwebWithSuffix() + "/dpswarningwebapis/foo", httpHeaderMap,
//					conditionMap, SysEnum.encodeUtf8.enumVal);
//			System.out.println(res);
//			assertTrue(true);
//		} catch (Exception e) {
//			System.out.println(e.toString());
//			Arrays.asList(e.getStackTrace()).stream().forEach(subex -> System.out.println(subex.toString()));
//			assertTrue(false);
//		}
//
//	}
//
////	@Test
//	public void encryptMD5() throws NoSuchAlgorithmException {
//		CommonAsi commonAsi = new CommonAsi();
//		String encryptStr = commonAsi.encrypt("asgard.com.tw", "MD5");
//		System.out.println(encryptStr);
//		assertTrue(true);
//	}
//
////	@Test
//	public void encryptBase64() {
//		try {
//			String encryptStr = EncryptBase64.encodeBytes("123456".getBytes());
//			byte[] decodeBytes = EncryptBase64.decode(encryptStr);
//			String originStr = new String(decodeBytes);
//			System.out.println(encryptStr);
//			System.out.println(originStr);
//			assertTrue(true);
//		} catch (Exception e) {
//			System.out.println(e.toString());
//			assertTrue(false);
//		}
//	}
//
//	@Test
//	public void encryptAES() {
//		try {
//			String encryptStr = EncryptAES.encrypt("123456");
//			System.out.println(encryptStr);
//			String res = EncryptAES.decrypt(encryptStr);
//			System.out.println(res);
//			Arrays.asList(res.getBytes()).stream().forEach(v -> System.out.println(String.valueOf(v)));
//		} catch (Exception e) {
//			System.out.println(e.toString());
//			assertTrue(false);
//		}
//	}

}
