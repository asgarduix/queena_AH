package com.asi.huanan.service.dao.mybatis.mapper.customerize;

public interface CustomerizeMapper {

//    @Select("SELECT\r\n" + 
//    		"	  YENDNW\r\n" + 
//    		"	FROM\r\n" + 
//    		"	  CUSTPF1 \r\n" + 
//    		"	WHERE\r\n" + 
//    		"	  POLYN1 = #{polyn1,jdbcType=CHAR}\r\n" + 
//    		"	  and PONO99 = #{pono99,jdbcType=CHAR}\r\n" + 
//    		"	  and OBJENO = #{objeno,jdbcType=SMALLINT}\r\n" + 
//    		"	  and YENDNW IS NOT NULL\r\n" + 
//    		"	ORDER BY UPDDAT DESC LIMIT 1")
//	List<Custpf1> queryCustpf1ByPolyn1Pono99Objeno(@Param("polyn1") String polyn1, @Param("pono99") String pono99, @Param("objeno") Short objeno);
//
//    @Select("SELECT\r\n" + 
//    		"	  a.YENDNW YENDNW,\r\n" + 
//    		"	  b.WNAME1 ax_NAMEI1, \r\n" + 
//    		"	  b.WLICNO ax_LICENO, \r\n" + 
//    		"	  b.WINDAT ax_INDDAT, \r\n" + 
//    		"	  b.WEXDAT ax_EXDDAT,\r\n" + 
//    		"	  b.YENPRO POLYMK,\r\n" + 
//    		"	  c.POLYN1 af_POLYN1, \r\n" + 
//    		"	  c.FCERNO af_FCERNO, \r\n" + 
//    		"	  c.WNAMEI af_NAMEIN, \r\n" + 
//    		"	  c.WLICNO af_LICENO, \r\n" + 
//    		"	  c.WINDAT af_INDDAT, \r\n" + 
//    		"	  c.WEXDAT af_EXTDAT\r\n" + 
//    		"	FROM\r\n" + 
//    		"	  (CUSTPF1 a JOIN AXENPF1 b ON a.YENDNW = b.YENDNO) JOIN AFENPF1 c \r\n" + 
//    		"	    on b.YENDNO = c.YENDNO \r\n" + 
//    		"	WHERE\r\n" + 
//    		"	  a.YENDNW = ( \r\n" + 
//    		"	    SELECT\r\n" + 
//    		"	      YENDNW \r\n" + 
//    		"	    FROM\r\n" + 
//    		"	      CUSTPF1 \r\n" + 
//    		"	    WHERE\r\n" + 
//    		"	      POLYN1 = #{ax_polyn1,jdbcType=CHAR}\r\n" + 
//    		"	      AND PONO99 = #{ax_polyn2,jdbcType=CHAR}\r\n" + 
//    		"	      AND OBJENO = #{ax_objeno,jdbcType=SMALLINT}\r\n" + 
//    		"	      AND YENDNW IS NOT NULL\r\n" + 
//    		"	ORDER BY UPDDAT DESC LIMIT 1\r\n" + 
//    		"	  )\r\n" + 
//    		"	  AND a.POLYN1 = #{ax_polyn1,jdbcType=CHAR}\r\n" + 
//    		"	  AND a.PONO99 = #{ax_polyn2,jdbcType=CHAR}\r\n" + 
//    		"	  AND a.OBJENO = #{ax_objeno,jdbcType=SMALLINT}\r\n" + 
//    		"	  ORDER BY a.UPDDAT DESC, a.YENDNW DESC")
//	List<Axafpopf> queryCustpf1JoinAxenpf1ByPolyn1Pono99Objeno(@Param("ax_polyn1") String ax_polyn1, @Param("ax_polyn2") String ax_polyn2, @Param("ax_objeno") Short ax_objeno);
//
//    @Select("SELECT\r\n" + 
//    		"	  a.NAMEI1 ax_NAMEI1, \r\n" + 
//    		"	  a.LICENO ax_LICENO, \r\n" + 
//    		"	  a.INDDAT ax_INDDAT, \r\n" + 
//    		"	  a.EXDDAT ax_EXDDAT, \r\n" + 
//    		"	  a.POLYMK POLYMK, \r\n" + 
//    		"	  b.POLYN1 af_POLYN1, \r\n" + 
//    		"	  b.FCERNO af_FCERNO, \r\n" + 
//    		"	  b.NAMEIN af_NAMEIN, \r\n" + 
//    		"	  b.LICENO af_LICENO, \r\n" + 
//    		"	  b.INDDAT af_INDDAT, \r\n" + 
//    		"	  b.EXTDAT af_EXTDAT \r\n" + 
//    		"	FROM\r\n" + 
//    		"	  AXPOPF1 a \r\n" + 
//    		"	  LEFT JOIN AFPOPF1 b \r\n" + 
//    		"	    ON a.LICENO = b.LICENO \r\n" + 
//    		"	    AND a.NAMEI1 = b.NAMEIN \r\n" + 
//    		"	WHERE\r\n" + 
//    		"	  a.POLYN1 = #{ax_polyn1,jdbcType=CHAR}\r\n" + 
//    		"	  AND a.POLYN2 = #{ax_polyn2,jdbcType=CHAR}\r\n" + 
//    		"	  AND a.objeno = #{ax_objeno,jdbcType=SMALLINT}\r\n" + 
//    		"	  ORDER BY a.UPDDAT DESC, a.POLYN2 DESC")
//    List<Axafpopf> queryAxpopf1ByPolyn1Polyn2Objeno(@Param("ax_polyn1") String ax_polyn1, @Param("ax_polyn2") String ax_polyn2, @Param("ax_objeno") Short ax_objeno);
//    
//	List<Custpf1> queryCustpf1ByPolyn1Pono99(@Param("polyn1") String polyn1, @Param("pono99") String pono99);
//
//	@Select("SELECT\r\n" + 
//			"	  * \r\n" + 
//			"	FROM\r\n" + 
//			"	  CUSTPF1 \r\n" + 
//			"	WHERE\r\n" + 
//			"	  PONO99 = #{pono99,jdbcType=CHAR}\r\n" + 
//			"	  AND YENDNW IS NOT NULL\r\n" + 
//			"	ORDER BY UPDDAT DESC LIMIT 1")
//	List<Custpf1> queryCustpf1ByPono99(@Param("pono99") String pono99);
//	
//	List<Axafpopf> queryCustpf1JoinAfenpf1ByPolyn1Pono99(@Param("ax_polyn1") String ax_polyn1, @Param("ax_polyn2") String ax_polyn2);
//
//	@Select("SELECT\r\n" + 
//			"	  a.YENDNW YENDNW,\r\n" + 
//			"	  c.POLYN1 ax_POLYN1,\r\n" + 
//			"	  c.POLYN2 ax_POLYN2,\r\n" + 
//			"	  c.OBJENO ax_OBJENO, \r\n" + 
//			"	  c.WNAME1 ax_NAMEI1, \r\n" + 
//			"	  c.WLICNO ax_LICENO,\r\n" + 
//			"	  c.WINDAT ax_INDDAT, \r\n" + 
//			"	  c.WEXDAT ax_EXDDAT,\r\n" + 
//			"	  b.POLYN1 af_POLYN1, \r\n" + 
//			"	  b.WNAMEI af_NAMEIN, \r\n" + 
//			"	  b.WLICNO af_LICENO, \r\n" + 
//			"	  b.WINDAT af_INDDAT, \r\n" + 
//			"	  b.WEXDAT af_EXTDAT,\r\n" + 
//			"	  b.YENPRO POLYMK\r\n" + 
//			"	FROM\r\n" + 
//			"	  (CUSTPF1 a join AFENPF1 b on a.YENDNW = b.YENDNO) join AXENPF1 c \r\n" + 
//			"	    on b.YENDNO = c.YENDNO \r\n" + 
//			"	WHERE\r\n" + 
//			"	  a.YENDNW = ( \r\n" + 
//			"	    select\r\n" + 
//			"	      YENDNW \r\n" + 
//			"	    from\r\n" + 
//			"	      CUSTPF1 \r\n" + 
//			"	    where\r\n" + 
//			"	      PONO99 = #{ax_polyn2,jdbcType=CHAR}\r\n" + 
//			"	      and YENDNW IS NOT NULL\r\n" + 
//			"	ORDER BY UPDDAT DESC LIMIT 1\r\n" + 
//			"	  )\r\n" + 
//			"	  AND a.PONO99 = #{ax_polyn2,jdbcType=CHAR}\r\n" + 
//			"	  ORDER BY a.UPDDAT DESC, a.YENDNW DESC")
//	List<Axafpopf> queryCustpf1JoinAfenpf1ByPono99(@Param("ax_polyn2") String ax_polyn2);
//	
//	@Select("SELECT\r\n" + 
//			"	  b.NAMEIN af_NAMEIN, \r\n" + 
//			"	  b.LICENO af_LICENO, \r\n" + 
//			"	  b.INDDAT af_INDDAT, \r\n" + 
//			"	  b.EXTDAT af_EXTDAT, \r\n" + 
//			"	  b.POLYN1 af_POLYN1, \r\n" + 
//			"	  b.POLYMK POLYMK,\r\n" + 
//			"	  a.POLYN1 ax_POLYN1, \r\n" + 
//			"	  a.POLYN2 ax_POLYN2, \r\n" + 
//			"	  a.OBJENO ax_OBJENO, \r\n" + 
//			"	  a.NAMEI1 ax_NAMEI1, \r\n" + 
//			"	  a.LICENO ax_LICENO, \r\n" + 
//			"	  a.INDDAT ax_INDDAT, \r\n" + 
//			"	  a.EXDDAT ax_EXDDAT\r\n" + 
//			"	FROM\r\n" + 
//			"	  AFPOPF1 b \r\n" + 
//			"	  LEFT JOIN AXPOPF1 a \r\n" + 
//			"	    ON b.LICENO = a.LICENO \r\n" + 
//			"	    AND b.NAMEIN = a.NAMEI1 \r\n" + 
//			"	WHERE\r\n" + 
//			"	  b.FCERNO = #{af_fcerno,jdbcType=CHAR}\r\n" + 
//			"	ORDER BY\r\n" + 
//			"	  a.UPDDAT DESC, a.POLYN2 DESC")
//	List<Axafpopf> queryAfpopf1ByFcerno(@Param("af_fcerno") String fcerno);
//
//	@Select("<script>"+"<choose>\r\n" + 
//			"		<when test=\"getidn == null or getidn == ''\">\r\n" + 
//			"    		SELECT YENDNO FROM AFENPF1 \r\n" + 
//			"    		WHERE 1=1 \r\n" + 
//			"    		<if test=\"axaf_idnumb != null and axaf_idnumb != ''\">\r\n" + 
//			"    		AND WIDNUM = #{axaf_idnumb,jdbcType=CHAR}\r\n" + 
//			"    		</if>\r\n" + 
//			"    		<if test=\"axaf_liceno != null and axaf_liceno != ''\">\r\n" + 
//			"    		AND WLICNO = #{axaf_liceno,jdbcType=CHAR} \r\n" + 
//			"    		</if>\r\n" + 
//			"    		AND YENDNO IS NOT NULL ORDER BY UPDDAT DESC, YENDNO DESC LIMIT 1\r\n" + 
//			"    	</when>\r\n" + 
//			"    	<otherwise>\r\n" + 
//			"		  	SELECT\r\n" + 
//			"		      YENDNW\r\n" + 
//			"		    FROM\r\n" + 
//			"		      CUSTPF1 \r\n" + 
//			"		    WHERE 1=1\r\n" + 
//			"		    <if test=\"getidn != null and getidn != ''\">\r\n" + 
//			"		        AND GETIDN = #{getidn,jdbcType=CHAR}\r\n" + 
//			"		    </if>\r\n" + 
//			"		      AND YENDNW IS NOT NULL\r\n" + 
//			"			ORDER BY UPDDAT DESC, YENDNW DESC LIMIT 1\r\n" + 
//			"    	</otherwise>\r\n" + 
//			"    </choose>"+ "</script>")
//	List<Custpf1> queryCustpf1ByLicenoIdnumbGetidn(@Param("axaf_liceno") String axaf_liceno, @Param("axaf_idnumb") String axaf_idnumb, @Param("getidn") String getidn);
//
//	@Select("<script>"+"SELECT\r\n" + 
//			"  	   A.YENDNW yendnw\r\n" + 
//			"	  , B.FCERNO axaf_fcerno\r\n" + 
//			"	  , B.WNAMEI axaf_namein\r\n" + 
//			"	  , B.WIDNUM axaf_idnumb\r\n" + 
//			"	  , B.WLICNO axaf_liceno\r\n" + 
//			"	  , B.WINDAT axaf_inddat\r\n" + 
//			"	  , B.WEXDAT axaf_extdat\r\n" + 
//			"	  , C.yeinki axaf_inskin\r\n" + 
//			"	  , A.GETNAM getnam\r\n" + 
//			"	  , A.GETIDN getidn\r\n" + 
//			"	FROM\r\n" + 
//			"	  (CUSTPF1 A join AFENPF1 B ON A.YENDNW = B.YENDNO) JOIN AFEIPF1 C\r\n" + 
//			"	  ON B.YENDNO = C.YENDNO\r\n" + 
//			"	WHERE  1=1" + 
//			"    <if test=\"axaf_liceno != null and axaf_liceno != ''\">\r\n" + 
//			"	AND B.WLICNO = #{axaf_liceno,jdbcType=CHAR}\r\n" + 
//			"	</if>\r\n" + 
//			"	<if test=\"getidn != null and getidn != ''\">\r\n" + 
//			"	AND A.GETIDN = #{getidn,jdbcType=CHAR}\r\n" + 
//			"	</if>\r\n" + 
//			"	<if test=\"axaf_idnumb != null and axaf_idnumb != ''\">\r\n" + 
//			"	AND B.WIDNUM = #{axaf_idnumb,jdbcType=CHAR}\r\n" + 
//			"	</if>\r\n" + 
//			"	<if test=\"policyStatus == 1\">\r\n" + 
//			"	AND  B.YENPRO IN ('1', '2', '3')\r\n" + 
//			"	</if>"+ "</script>")
//	List<Axafpopf2> queryCustpf1FByLicenoIdnumbGetidn(@Param("axaf_liceno") String axaf_liceno, @Param("axaf_idnumb") String axaf_idnumb, @Param("getidn") String getidn, @Param("policyStatus") String policyStatus);
//
//	@Select("<script>"+"SELECT\r\n" + 
//			"  	  A.YENDNW yendnw\r\n" + 
//			"	  , B.POLYN2 axaf_fcerno\r\n" + 
//			"	  , B.WNAME1 axaf_namein\r\n" + 
//			"	  , B.WIDNUM axaf_idnumb\r\n" + 
//			"	  , B.WLICNO axaf_liceno\r\n" + 
//			"	  , B.WINDAT axaf_inddat\r\n" + 
//			"	  , B.WEXDAT axaf_extdat\r\n" + 
//			"	  , C.KININS axaf_inskin\r\n" + 
//			"	  , A.GETNAM getnam\r\n" + 
//			"	  , A.GETIDN getidn\r\n" + 
//			"	FROM\r\n" + 
//			"	  (CUSTPF1 A join AXENPF1 B ON A.YENDNW = B.YENDNO) JOIN AXEIPF1 C \r\n" + 
//			"	    ON B.YENDNO = C.YENDNO \r\n" + 
//			"	WHERE 1=1"+ 
//			"	  <if test=\"axaf_liceno != null and axaf_liceno != ''\">\r\n" + 
//			"	  AND B.WLICNO = #{axaf_liceno,jdbcType=CHAR}\r\n" + 
//			"	  </if>\r\n" + 
//			"	  <if test=\"getidn != null and getidn != ''\">\r\n" + 
//			"	  AND A.GETIDN = #{getidn,jdbcType=CHAR}\r\n" + 
//			"	  </if>\r\n" + 
//			"	  <if test=\"axaf_idnumb != null and axaf_idnumb != ''\">\r\n" + 
//			"	  AND B.WIDNUM = #{axaf_idnumb,jdbcType=CHAR}\r\n" + 
//			"	  </if>\r\n" + 
//			"	  <if test=\"policyStatus == 1\">\r\n" + 
//			"	  AND  B.YENPRO IN ('1', '2', '3')\r\n" + 
//			"	  </if>"+ "</script>")
//	List<Axafpopf2> queryCustpf1XByLicenoIdnumbGetidn(@Param("axaf_liceno") String axaf_liceno, @Param("axaf_idnumb") String axaf_idnumb, @Param("getidn") String getidn, @Param("policyStatus") String policyStatus);
//
//	@Select("<script>"+"SELECT\r\n" + 
//			"  	  A.YENDNW yendnw,\r\n" + 
//			"	  B.FCERNO axaf_fcerno,\r\n" + 
//			"	  B.NAMEIN axaf_namein,\r\n" + 
//			"	  B.IDNUMB axaf_idnumb,\r\n" + 
//			"	  B.LICENO axaf_liceno,\r\n" + 
//			"	  B.INDDAT axaf_inddat,\r\n" + 
//			"	  B.EXTDAT axaf_extdat,\r\n" + 
//			"	  C.INSKIN axaf_inskin,\r\n" + 
//			"	  A.GETNAM getnam,\r\n" + 
//			"	  A.GETIDN getidn\r\n" + 
//			"	FROM\r\n" + 
//			"	  (CUSTPF1 A join AFPOPF1 B ON A.PONO99 = B.FCERNO AND A.POLYN1 = B.POLYN1 ) JOIN AFPIPF1 C\r\n" + 
//			"	  ON B.FCERNO = C.FCERNO\r\n" + 
//			"	WHERE 1=1 \r\n" + 
//			"	<if test=\"axaf_liceno != null and axaf_liceno != ''\">\r\n" + 
//			"    AND B.LICENO = #{axaf_liceno,jdbcType=CHAR}\r\n" + 
//			"    </if>\r\n" + 
//			"    <if test=\"getidn != null and getidn != ''\">\r\n" + 
//			"	AND A.GETIDN = #{getidn,jdbcType=CHAR}\r\n" + 
//			"	</if>\r\n" + 
//			"	<if test=\"axaf_idnumb != null and axaf_idnumb != ''\">\r\n" + 
//			"	AND B.IDNUMB = #{axaf_idnumb,jdbcType=CHAR}\r\n" + 
//			"	</if>\r\n" + 
//			"	<if test=\"policyStatus == 1\">\r\n" + 
//			"	AND  B.POLYMK IN ('1', '2', '3')\r\n" + 
//			"	</if>\r\n" + 
//			"	ORDER BY A.UPDDAT DESC, A.YENDNW DESC"+ "</script>")
//	List<Axafpopf2> queryAfpopf1FByLicenoIdnumbGetidn(@Param("axaf_liceno") String axaf_liceno, @Param("axaf_idnumb") String axaf_idnumb, @Param("getidn") String getidn, @Param("policyStatus") String policyStatus);
//
//	@Select("<script>"+"<choose>\r\n" + 
//			"		<when test=\"getidn == null or getidn == ''\">\r\n" + 
//			"    		SELECT YENDNO FROM AXENPF1 \r\n" + 
//			"    		WHERE 1=1 \r\n" + 
//			"    		<if test=\"axaf_idnumb != null and axaf_idnumb != ''\">\r\n" + 
//			"    		AND WIDNUM = #{axaf_idnumb,jdbcType=CHAR}\r\n" + 
//			"    		</if>\r\n" + 
//			"    		<if test=\"axaf_liceno != null and axaf_liceno != ''\">\r\n" + 
//			"    		AND WLICNO = #{axaf_liceno,jdbcType=CHAR} \r\n" + 
//			"    		</if>\r\n" + 
//			"    		AND YENDNO IS NOT NULL ORDER BY UPDDAT DESC, YENDNO DESC LIMIT 1\r\n" + 
//			"    	</when>\r\n" + 
//			"    	<otherwise>\r\n" + 
//			"		  	SELECT\r\n" + 
//			"		      YENDNW\r\n" + 
//			"		    FROM\r\n" + 
//			"		      CUSTPF1 \r\n" + 
//			"		    WHERE 1=1\r\n" + 
//			"		    <if test=\"getidn != null and getidn != ''\">\r\n" + 
//			"		        AND GETIDN = #{getidn,jdbcType=CHAR}\r\n" + 
//			"		    </if>\r\n" + 
//			"		      AND YENDNW IS NOT NULL\r\n" + 
//			"			ORDER BY UPDDAT DESC, YENDNW DESC LIMIT 1\r\n" + 
//			"    	</otherwise>\r\n" + 
//			"    </choose>"+ "</script>")
//	List<Custpf1> queryXCustpf1ByLicenoIdnumbGetidn(@Param("axaf_liceno") String axaf_liceno, @Param("axaf_idnumb") String axaf_idnumb, @Param("getidn") String getidn);
//	
//	@Select("<script>"+"SELECT\r\n" + 
//			"  	  A.YENDNW yendnw,\r\n" + 
//			"	  B.POLYN2 axaf_fcerno,\r\n" + 
//			"	  B.NAMEI1 axaf_namein,\r\n" + 
//			"	  B.IDNUMB axaf_idnumb,\r\n" + 
//			"	  B.LICENO axaf_liceno,\r\n" + 
//			"	  B.INDDAT axaf_inddat,\r\n" + 
//			"	  B.EXDDAT axaf_extdat,\r\n" + 
//			"	  C.KININS axaf_inskin,\r\n" + 
//			"	  A.GETNAM getnam,\r\n" + 
//			"	  A.GETIDN getidn\r\n" + 
//			"	FROM\r\n" + 
//			"	  (CUSTPF1 A join AXPOPF1 B ON A.PONO99 = B.POLYN2 AND A.POLYN1 = B.POLYN1 ) JOIN AXPIPF1 C\r\n" + 
//			"	  ON B.POLYN2 = C.POLYN2\r\n" + 
//			"	WHERE 1=1  \r\n" + 
//			"	<if test=\"axaf_liceno != null and axaf_liceno != ''\">\r\n" + 
//			"    AND B.LICENO = #{axaf_liceno,jdbcType=CHAR}\r\n" + 
//			"    </if>\r\n" + 
//			"    <if test=\"getidn != null and getidn != ''\">\r\n" + 
//			"	AND A.GETIDN = #{getidn,jdbcType=CHAR}\r\n" + 
//			"	</if>\r\n" + 
//			"	<if test=\"axaf_idnumb != null and axaf_idnumb != ''\">\r\n" + 
//			"	AND B.IDNUMB = #{axaf_idnumb,jdbcType=CHAR}\r\n" + 
//			"	</if>\r\n" + 
//			"	<if test=\"policyStatus == 1\">\r\n" + 
//			"	AND  B.POLYMK IN ('1', '2', '3')\r\n" + 
//			"	</if>"+ "</script>")
//	List<Axafpopf2> queryAxpopf1XByLicenoIdnumbGetidn(@Param("axaf_liceno") String axaf_liceno, @Param("axaf_idnumb") String axaf_idnumb, @Param("getidn") String getidn, @Param("policyStatus") String policyStatus);
//
//	//批單建檔(同人車)
//	List<Axafpopf2> queryAfByWIGS(@Param("axaf_liceno") String axaf_liceno, @Param("axaf_idnumb") String axaf_idnumb, @Param("axaf_getidn") String axaf_getidn, @Param("policyStatus") String policyStatus);
//	
//	List<Axafpopf2> queryAxByWIGS(@Param("axaf_liceno") String axaf_liceno, @Param("axaf_idnumb") String axaf_idnumb, @Param("axaf_getidn") String axaf_getidn, @Param("policyStatus") String policyStatus);
//
//	@Select("<script>"+
//			"SELECT\r\n" + 
//			"  	A.YENDNO, A.CRTDAT, A.OPRNUM, A.YENPRO, A.ENVDAT, A.PRTDAT, A.YRETIM, B.RPAY_COND, A.AUTPRO,\r\n" + 
//			"   	A.MONCHK, A.WINDAT, A.WEXDAT, A.WMONTH, B.EPOMAK, A.ACCOPR, B.CHKOPR1, B.CHKOPR2, B.CHKOPR3,\r\n" + 
//			"	A.WNAMEI, A.WNAMMK, A.WIDNUM, B.SPNRNAM1, A.WNATMK, B.CNTCOD, B.CNTNAM, A.WBIDAT, A.WMKSEX, A.WMARRI,\r\n" + 
//			"    A.WADREN, A.WMAILA, A.ZIPCOD, A.WADDRE, A.WTELN2, A.WTELN1, A.WTELN3, B.EMAIL, B.JOBNO, B.RELTIN, B.RELTINDES,\r\n" + 
//			"    B.GETNAM, B.GETIDN, B.SPNRNAM2, B.GETNAT, B.GETCNTC, B.GETCNTN, B.GETBRI, B.GETSEX, B.GETANO, B.GETADD, B.GETTEL,\r\n" + 
//			"	A.INSSRC, A.SALDEP, B.PROJEC, B.CAMPCD, A.SOLIN1, A.SOLIN2, A.SALCOD, A.SALNAM,\r\n" + 
//			"    B.BKCOD1, B.PIDNUM, B.PNAMEI, B.BKCOD2, B.PIDNUM2, B.PNAMEI2, B.ACCEPTNO\r\n" + 
//			"	FROM\r\n" + 
//			"  	AFENPF1 A join CUSTPF1 B \r\n" + 
//			"    ON A.YENDNO = B.YENDNW\r\n" + 
//			"	WHERE 1=1\r\n" + 
//			"	<if test=\"yendnw != null and yendnw != ''\">\r\n" + 
//			"	AND A.YENDNO = #{yendnw}\r\n" + 
//			"	</if>\r\n" + 
//			"	<if test=\"fcerno != null and fcerno != ''\">\r\n" + 
//			"	AND A.FCERNO = #{fcerno}\r\n" + 
//			"	</if>\r\n" + 
//			"	<if test=\"polyn1 != null and polyn1 != ''\">\r\n" + 
//			"	AND A.POLYN1 = #{polyn1}\r\n" + 
//			"	</if>\r\n" + 
//			"	ORDER BY B.UPDDAT DESC, B.YENDNW DESC"+ "</script>")
//	List<PolicyChangeInside> policyChangeInsideModified1(@Param("polyn1") String polyn1, @Param("yendnw") String yendnw, @Param("fcerno") String fcerno);
//	
//	@Select("<script>"+
//			"SELECT\r\n" + 
//			"	A.CRTDAT, A.OPRNUM, A.POLYMK YENPRO, B.RPAY_COND, A.INDDAT WINDAT, A.EXTDAT WEXDAT, A.MONTHS WMONTH,\r\n" + 
//			"	B.EPOMAK, B.CHKOPR1, B.CHKOPR2, B.CHKOPR3,\r\n" + 
//			"	A.NAMEIN WNAMEI, A.IDNUMB WIDNUM, B.SPNRNAM1, A.NATIMK WNATMK, B.CNTCOD, B.CNTNAM, A.BIRDAT WBIDAT, A.MKSEXS WMKSEX, A.MARRID WMARRI,\r\n" + 
//			"    A.ADREN1 WADREN, A.MAILAD WMAILA, A.ADRENO ZIPCOD, A.ADDRES WADDRE, A.TELNO2 WTELN2, A.TELNO1 WTELN1, A.TELNO3 WTELN3, B.EMAIL, B.JOBNO, B.RELTIN, B.RELTINDES,\r\n" + 
//			"    B.GETNAM, B.GETIDN, B.SPNRNAM2, B.GETNAT, B.GETCNTC, B.GETCNTN, B.GETBRI, B.GETSEX, B.GETANO, B.GETADD, B.GETTEL,\r\n" + 
//			"	A.INSSRC, A.SALDEP, B.PROJEC, B.CAMPCD, A.SOLIN1, A.SOLIN2, A.SALCOD, A.FIL1 SALNAM,\r\n" + 
//			"    B.BKCOD1, B.PIDNUM, B.PNAMEI, B.BKCOD2, B.PIDNUM2, B.PNAMEI2, B.ACCEPTNO\r\n" + 
//			"	FROM\r\n" + 
//			"	AFPOPF1 A JOIN CUSTPF1 B\r\n" + 
//			"	ON A.FCERNO = B.PONO99\r\n" + 
//			"	WHERE 1=1\r\n" + 
//			"	<if test=\"fcerno != null and fcerno != ''\">\r\n" + 
//			"	AND A.FCERNO = #{fcerno}\r\n" + 
//			"	</if>\r\n" + 
//			"	<if test=\"polyn1 != null and polyn1 != ''\">\r\n" + 
//			"	AND A.POLYN1 = #{polyn1}\r\n" + 
//			"	</if>\r\n" + 
//			"	ORDER BY B.UPDDAT DESC"+ "</script>")
//	List<PolicyChangeInside> policyChangeInsideModified2(@Param("polyn1") String polyn1, @Param("fcerno") String fcerno);
//	
//	@Select("<script>"+
//			"SELECT\r\n" + 
//			"			A.YENDNO, A.CRTDAT, A.OPRNUM, A.YENPRO, A.ENVDAT, A.PRTDAT, A.PRTTIM yretim,\r\n" + 
//			"			B.RPAY_COND, A.AUTPRO, A.MONCHK, A.WINDAT, A.WEXDAT, A.WMONTH, B.epomak,\r\n" + 
//			"			A.ACCOPR, B.CHKOPR1, B.CHKOPR2, B.CHKOPR3, B.GETTEL,\r\n" + 
//			"			A.WNAME1 wnamei, A.WNAMMK, A.WIDNUM, B.SPNRNAM1, A.WNATMK, B.CNTCOD, B.CNTNAM,\r\n" + 
//			"			A.WBRDAT wbidat, A.WMKSEX, A.WMARRI, A.WZIPCO wadren, A.WMAILA, A.ZIPCOD, A.WADDRE, A.WTENO2 wteln2, A.WTENO1 wteln1, A.WTENO3 wteln3,\r\n" + 
//			"			B.EMAIL, B.JOBNO, B.RELTIN, B.RELTINDES, B.GETNAM, B.GETIDN, B.SPNRNAM2, B.GETNAT, B.GETCNTC,\r\n" + 
//			"			B.GETBRI, B.GETSEX, B.GETANO, B.GETADD, B.GETTEL,\r\n" + 
//			"			A.INSSRC, A.SALDEP, B.PROJEC, B.CAMPCD,A.SOLIN1, A.SOLIN2, A.SALCOD, A.SALNAM,\r\n" + 
//			"			B.BKCOD1, B.PIDNUM, B.PNAMEI, B.BKCOD2, B.PIDNUM2, B.PNAMEI2, B.ACCEPTNO\r\n" + 
//			"			\r\n" + 
//			"		FROM\r\n" + 
//			"			AXENPF1 A JOIN CUSTPF1 B\r\n" + 
//			"			ON A.YENDNO = B.YENDNW\r\n" + 
//			"		<where>\r\n" + 
//			"			<if test=\"yendnw != null and yendnw != ''\">\r\n" + 
//			"				B.YENDNW = #{yendnw,jdbcType=CHAR}\r\n" + 
//			"			</if>\r\n" + 
//			"			<if test=\"polyn1 != null and polyn1 != ''\">\r\n" + 
//			"			AND A.POLYN1 = #{polyn1,jdbcType=CHAR}\r\n" + 
//			"			</if>\r\n" + 
//			"			<if test=\"polyn2 != null and polyn2 != ''\">\r\n" + 
//			"			AND A.POLYN2 = #{polyn2,jdbcType=CHAR}\r\n" + 
//			"			</if>\r\n" + 
//			"			<if test=\"objeno != null \">\r\n" + 
//			"           AND A.OBJENO = #{objeno,jdbcType=SMALLINT}\r\n"+
//			"			</if>\r\n" + 
//			"		</where>\r\n" + 
//			"			ORDER BY B.UPDDAT DESC LIMIT 1"+ "</script>")
//	List<PolicyChangeInside> policyChangeInsideAxModified1(@Param("yendnw") String yendnw, @Param("polyn1") String polyn1,
//			@Param("polyn2") String polyn2, @Param("objeno") Short objeno);
//	
//	@Select("<script>"+
//			"SELECT\r\n" + 
//			"			A.CRTDAT, A.OPRNUM, A.POLYMK YENPRO, B.RPAY_COND, A.INDDAT WINDAT, A.EXDDAT WEXDAT, A.MONTHS WMONTH,\r\n" + 
//			"			B.EPOMAK, B.CHKOPR1, B.CHKOPR2, B.CHKOPR3, B.GETTEL,\r\n" + 
//			"			A.NAMEI1 WNAMEI, A.IDNUMB WIDNUM, B.SPNRNAM1, A.NATIMK WNATMK, B.CNTCOD, B.CNTNAM, A.BRIDAT WBIDAT, A.MKSEXS WMKSEX, A.MARRID WMARRI,\r\n" + 
//			"			A.ZIPCO1 WADREN, A.MAILAD WMAILA, A.ZIPCOD ZIPCOD, A.ADDRES WADDRE, A.TELNO2 WTELN2, A.TELNO1 WTELN1, A.TELNO3 WTELN3, B.EMAIL, B.JOBNO, B.RELTIN,\r\n" + 
//			"			B.GETNAM, B.GETIDN, B.SPNRNAM2, B.GETNAT, B.GETCNTC, B.GETCNTN, B.GETBRI, B.GETSEX, B.GETANO, B.GETADD, B.GETTEL,\r\n" + 
//			"			A.INSSRC, A.SALDEP, B.PROJEC, B.CAMPCD,A.SOLIN1, A.SOLIN2, A.SALCOD, A.SALNAM,\r\n" + 
//			"			B.BKCOD1, B.PIDNUM, B.PNAMEI, B.BKCOD2, B.PIDNUM2, B.PNAMEI2, B.ACCEPTNO\r\n" + 
//			"		FROM\r\n" + 
//			"			AXPOPF1 A JOIN CUSTPF1 B\r\n" + 
//			"			ON A.POLYN2 = B.PONO99\r\n" + 
//			"		<where>\r\n" + 
//			"			<if test=\"polyn1 != null and polyn1 != ''\">\r\n" + 
//			"			A.POLYN1 = #{polyn1,jdbcType=CHAR}\r\n" + 
//			"			</if>\r\n" + 
//			"			<if test=\"polyn2 != null and polyn2 != ''\">\r\n" + 
//			"			AND A.POLYN2 = #{polyn2,jdbcType=CHAR}\r\n" + 
//			"			</if>\r\n" + 
//			"			<if test=\"objeno != null \">\r\n" + 
//			"           AND A.OBJENO = #{objeno,jdbcType=SMALLINT}\r\n"+
//			"			</if>\r\n" + 
//			"		</where>\r\n" + 
//			"			ORDER BY B.UPDDAT DESC LIMIT 1"+ "</script>")
//	List<PolicyChangeInside> policyChangeInsideAxModified2(@Param("polyn1") String polyn1, @Param("polyn2") String polyn2,
//			@Param("objeno") Short objeno);
//	
//	/**
//	 * 查詢強制 保/批單資料
//	 * @param yendnw
//	 * @param fcerno
//	 * @return
//	 */
//	@Select("<script>"+"SELECT\r\n" + 
//			"  	A.YENDNO, A.CRTDAT, A.OPRNUM, A.YENPRO, A.ENVDAT, A.PRTDAT, A.YRETIM, B.RPAY_COND, A.AUTPRO,\r\n" + 
//			"   	A.MONCHK, A.WINDAT, A.WEXDAT, A.WMONTH, B.EPOMAK, A.ACCOPR, B.CHKOPR1, B.CHKOPR2, B.CHKOPR3\r\n" + 
//			"	FROM\r\n" + 
//			"  	AFENPF1 A join CUSTPF1 B \r\n" + 
//			"    ON A.YENDNO = B.YENDNW\r\n" + 
//			"	WHERE 1=1\r\n" + 
//			"	<if test=\"yendnw != null and yendnw != ''\">\r\n" + 
//			"	AND B.YENDNW = #{yendnw,jdbcType=CHAR}\r\n" + 
//			"	</if>\r\n" + 
//			"	<if test=\"fcerno != null and fcerno != ''\">\r\n" + 
//			"	AND A.FCERNO = #{fcerno,jdbcType=CHAR}\r\n" + 
//			"	</if>\r\n" + 
//			"	ORDER BY B.UPDDAT DESC, B.YENDNW DESC"+ "</script>")
//	List<PolicyChangeInside> policyChangeInsidef001_1(@Param("yendnw") String yendnw, @Param("fcerno") String fcerno);
//	
//	/**
//	 * 查詢強制 保/批單資料
//	 * @param fcerno
//	 * @return
//	 */
//	@Select("<script>"+"SELECT\r\n" + 
//			"	A.CRTDAT, A.OPRNUM, A.POLYMK YENPRO, B.RPAY_COND, A.INDDAT WINDAT, A.EXTDAT WEXDAT, A.MONTHS WMONTH,\r\n" + 
//			"	B.EPOMAK, B.CHKOPR1, B.CHKOPR2, B.CHKOPR3\r\n" + 
//			"	FROM\r\n" + 
//			"	AFPOPF1 A JOIN CUSTPF1 B\r\n" + 
//			"	ON A.FCERNO = B.PONO99\r\n" + 
//			"	WHERE 1=1\r\n" + 
//			"	<if test=\"fcerno != null and fcerno != ''\">\r\n" + 
//			"	AND A.FCERNO = #{fcerno,jdbcType=CHAR}\r\n" + 
//			"	</if>\r\n" + 
//			"	ORDER BY B.UPDDAT DESC"+ "</script>")
//	List<PolicyChangeInside> policyChangeInsidef001_2(@Param("fcerno") String fcerno);
//	
//	/**
//	 * 查詢強制 車主資料-要被保險人
//	 * @param yendnw
//	 * @param fcerno
//	 * @return
//	 */
//	@Select("<script>"+"SELECT\r\n" + 
//			"  	A.WNAMEI, A.WNAMMK, A.WIDNUM, B.SPNRNAM1, A.WNATMK, B.CNTCOD, B.CNTNAM, A.WBIDAT, A.WMKSEX, A.WMARRI,\r\n" + 
//			"    A.WADREN, A.WMAILA, A.ZIPCOD, A.WADDRE, A.WTELN2, A.WTELN1, A.WTELN3, B.EMAIL, B.JOBNO, B.RELTIN, B.RELTINDES,\r\n" + 
//			"    B.GETNAM, B.GETIDN, B.SPNRNAM2, B.GETNAT, B.GETCNTC, B.GETCNTN, B.GETBRI, B.GETSEX, B.GETANO, B.GETADD, B.GETTEL\r\n" + 
//			"	FROM\r\n" + 
//			"  	AFENPF1 A join CUSTPF1 B \r\n" + 
//			"    ON A.YENDNO = B.YENDNW\r\n" + 
//			"	WHERE 1=1\r\n" + 
//			"	<if test=\"yendnw != null and yendnw != ''\">\r\n" + 
//			"	AND B.YENDNW = #{yendnw,jdbcType=CHAR}\r\n" + 
//			"	</if>\r\n" + 
//			"	<if test=\"fcerno != null and fcerno != ''\">\r\n" + 
//			"	AND A.FCERNO = #{fcerno,jdbcType=CHAR}\r\n" + 
//			"	</if>\r\n" + 
//			"	ORDER BY B.UPDDAT DESC, B.YENDNW DESC"+ "</script>")
//	List<PolicyChangeInside> policyChangeInsidef002_1(@Param("yendnw") String yendnw, @Param("fcerno") String fcerno);
//	
//	/**
//	 * 查詢強制 車主資料-要被保險人
//	 * @param fcerno
//	 * @return
//	 */
//	@Select("<script>"+"SELECT\r\n" + 
//			"	A.NAMEIN WNAMEI, A.IDNUMB WIDNUM, B.SPNRNAM1, A.NATIMK WNATMK, B.CNTCOD, B.CNTNAM, A.BIRDAT WBIDAT, A.MKSEXS WMKSEX, A.MARRID WMARRI,\r\n" + 
//			"    A.ADREN1 WADREN, A.MAILAD WMAILA, A.ADRENO ZIPCOD, A.ADDRES WADDRE, A.TELNO2 WTELN2, A.TELNO1 WTELN1, A.TELNO3 WTELN3, B.EMAIL, B.JOBNO, B.RELTIN, B.RELTINDES,\r\n" + 
//			"    B.GETNAM, B.GETIDN, B.SPNRNAM2, B.GETNAT, B.GETCNTC, B.GETCNTN, B.GETBRI, B.GETSEX, B.GETANO, B.GETADD, B.GETTEL\r\n" + 
//			"	FROM\r\n" + 
//			"	AFPOPF1 A JOIN CUSTPF1 B\r\n" + 
//			"	ON A.FCERNO = B.PONO99\r\n" + 
//			"	WHERE 1=1\r\n" + 
//			"	<if test=\"fcerno != null and fcerno != ''\">\r\n" + 
//			"	AND A.FCERNO = #{fcerno,jdbcType=CHAR}\r\n" + 
//			"	</if>\r\n" + 
//			"	ORDER BY B.UPDDAT DESC"+ "</script>")
//	List<PolicyChangeInside> policyChangeInsidef002_2(@Param("fcerno") String fcerno);
//	
//	/**
//	 * 查詢強制  業務來源/其它
//	 * @param yendnw
//	 * @param fcerno
//	 * @return
//	 */
//	@Select("<script>"+"SELECT\r\n" + 
//			"  	A.INSSRC, A.SALDEP, B.PROJEC, B.CAMPCD, A.SOLIN1, A.SOLIN2, A.SALCOD, A.SALNAM,\r\n" + 
//			"    B.BKCOD1, B.PIDNUM, B.PNAMEI, B.BKCOD2, B.PIDNUM2, B.PNAMEI2, B.ACCEPTNO\r\n" + 
//			"	FROM\r\n" + 
//			"  	AFENPF1 A join CUSTPF1 B \r\n" + 
//			"    ON A.YENDNO = B.YENDNW\r\n" + 
//			"	WHERE 1=1\r\n" + 
//			"	<if test=\"yendnw != null and yendnw != ''\">\r\n" + 
//			"	AND B.YENDNW = #{yendnw,jdbcType=CHAR}\r\n" + 
//			"	</if>\r\n" + 
//			"	<if test=\"fcerno != null and fcerno != ''\">\r\n" + 
//			"	AND A.FCERNO = #{fcerno,jdbcType=CHAR}\r\n" + 
//			"	</if>\r\n" + 
//			"	ORDER BY B.UPDDAT DESC, B.YENDNW DESC"+ "</script>")
//	List<PolicyChangeInside> policyChangeInsidef004_1(@Param("yendnw") String yendnw, @Param("fcerno") String fcerno);
//	
//	/**
//	 * 查詢強制  業務來源/其它
//	 * @param fcerno
//	 * @return
//	 */
//	@Select("<script>"+"SELECT\r\n" + 
//			"	A.INSSRC, A.SALDEP, B.PROJEC, B.CAMPCD, A.SOLIN1, A.SOLIN2, A.SALCOD, A.FIL1 SALNAM,\r\n" + 
//			"    B.BKCOD1, B.PIDNUM, B.PNAMEI, B.BKCOD2, B.PIDNUM2, B.PNAMEI2, B.ACCEPTNO\r\n" + 
//			"	FROM\r\n" + 
//			"	AFPOPF1 A JOIN CUSTPF1 B\r\n" + 
//			"	ON A.FCERNO = B.PONO99\r\n" + 
//			"	WHERE 1=1\r\n" + 
//			"	<if test=\"fcerno != null and fcerno != ''\">\r\n" + 
//			"	AND A.FCERNO = #{fcerno,jdbcType=CHAR}\r\n" + 
//			"	</if>\r\n" + 
//			"	ORDER BY B.UPDDAT DESC"+ "</script>")
//	List<PolicyChangeInside> policyChangeInsidef004_2(@Param("fcerno") String fcerno);
//
//	/**
//	 *  查詢任意 保/批單資料
//	 * @param yendnw
//	 * @param polyn1
//	 * @param polyn2
//	 * @return
//	 * @throws Exception 
//	 */
//	@Select("<script>"+"SELECT\r\n" + 
//			"			A.YENDNO, A.CRTDAT, A.OPRNUM, A.YENPRO, A.ENVDAT, A.PRTDAT, A.PRTTIM yretim,\r\n" + 
//			"			B.RPAY_COND, A.AUTPRO, A.MONCHK, A.WINDAT, A.WEXDAT, A.WMONTH, B.epomak,\r\n" + 
//			"			A.ACCOPR, B.CHKOPR1, B.CHKOPR2, B.CHKOPR3, B.GETTEL\r\n" + 
//			"			\r\n" + 
//			"		FROM\r\n" + 
//			"			AXENPF1 A JOIN CUSTPF1 B\r\n" + 
//			"			ON A.YENDNO = B.YENDNW\r\n" + 
//			"		<where>\r\n" + 
//			"			<if test=\"yendnw != null and yendnw != ''\">\r\n" + 
//			"				B.YENDNW = #{yendnw,jdbcType=CHAR}\r\n" + 
//			"			</if>\r\n" + 
//			"			<if test=\"polyn1 != null and polyn1 != ''\">\r\n" + 
//			"			AND A.POLYN1 = #{polyn1,jdbcType=CHAR}\r\n" + 
//			"			</if>\r\n" + 
//			"			<if test=\"polyn2 != null and polyn2 != ''\">\r\n" + 
//			"			AND A.POLYN2 = #{polyn2,jdbcType=CHAR}\r\n" + 
//			"			</if>\r\n" + 
//			"		</where>\r\n" + 
//			"			ORDER BY B.UPDDAT DESC LIMIT 1"+ "</script>")
//	List<PolicyChangeInside> queryAxInsideData001(@Param("yendnw") String yendnw, @Param("polyn1") String polyn1,
//			@Param("polyn2") String polyn2);
//
//
//	/**
//	 *  查詢任意 保/批單資料
//	 * @param polyn1
//	 * @param polyn2
//	 * @return
//	 * @throws Exception 
//	 */
//	@Select("<script>"+"SELECT\r\n" + 
//			"			A.CRTDAT, A.OPRNUM, A.POLYMK YENPRO, B.RPAY_COND, A.INDDAT WINDAT, A.EXTDAT WEXDAT, A.MONTHS WMONTH,\r\n" + 
//			"			B.EPOMAK, B.CHKOPR1, B.CHKOPR2, B.CHKOPR3, B.GETTEL\r\n" + 
//			"		FROM\r\n" + 
//			"			AXPOPF1 A JOIN CUSTPF1 B\r\n" + 
//			"			ON A.POLYN2 = B.PONO99\r\n" + 
//			"		<where>\r\n" + 
//			"			<if test=\"polyn1 != null and polyn1 != ''\">\r\n" + 
//			"			A.POLYN1 = #{polyn1,jdbcType=CHAR}\r\n" + 
//			"			</if>\r\n" + 
//			"			<if test=\"polyn2 != null and polyn2 != ''\">\r\n" + 
//			"			AND A.POLYN2 = #{polyn2,jdbcType=CHAR}\r\n" + 
//			"			</if>\r\n" + 
//			"		</where>\r\n" + 
//			"			ORDER BY B.UPDDAT DESC LIMIT 1"+ "</script>")
//	List<PolicyChangeInside> queryAxInsideData001_1(@Param("polyn1") String polyn1, @Param("polyn2") String polyn2);
//
//	/**
//	 *  查詢任意 車主資料-要被保險人
//	 * @param yendnw
//	 * @param polyn1
//	 * @param polyn2
//	 * @return
//	 * @throws Exception 
//	 */
//	@Select("<script>"+"SELECT\r\n" + 
//			"			A.WNAME1 wnamei, A.WNAMMK, A.WIDNUM, B.SPNRNAM1, A.WNATMK, B.CNTCOD, B.CNTNAM,\r\n" + 
//			"			A.WBRDAT wbidat, A.WMKSEX, A.WMARRI, A.WZIPCO wadren, A.WMAILA, A.ZIPCOD, A.WADDRE, A.WTENO2 wteln2, A.WTENO1 wteln1, A.WTENO3 wteln3,\r\n" + 
//			"			B.EMAIL, B.JOBNO, B.RELTIN, B.RELTINDES, B.GETNAM, B.GETIDN, B.SPNRNAM2, B.GETNAT, B.GETCNTC,\r\n" + 
//			"			B.GETBRI, B.GETSEX, B.GETANO, B.GETADD, B.GETTEL\r\n" + 
//			"		FROM\r\n" + 
//			"			AXENPF1 A JOIN CUSTPF1 B\r\n" + 
//			"			ON A.YENDNO = B.YENDNW\r\n" + 
//			"		<where>\r\n" + 
//			"			<if test=\"yendnw != null and yendnw != ''\">\r\n" + 
//			"				B.YENDNW = #{yendnw,jdbcType=CHAR}\r\n" + 
//			"			</if>\r\n" + 
//			"			<if test=\"polyn1 != null and polyn1 != ''\">\r\n" + 
//			"			AND A.POLYN1 = #{polyn1,jdbcType=CHAR}\r\n" + 
//			"			</if>\r\n" + 
//			"			<if test=\"polyn2 != null and polyn2 != ''\">\r\n" + 
//			"			AND A.POLYN2 = #{polyn2,jdbcType=CHAR}\r\n" + 
//			"			</if>\r\n" + 
//			"		</where>\r\n" + 
//			"			ORDER BY B.UPDDAT DESC LIMIT 1"+ "</script>")
//	List<PolicyChangeInside> queryAxInsideData002(@Param("yendnw") String yendnw, @Param("polyn1") String polyn1,
//			@Param("polyn2") String polyn2);
//
//	/**
//	 *  查詢任意 車主資料-要被保險人
//	 * @param polyn1
//	 * @param polyn2
//	 * @return
//	 * @throws Exception 
//	 */
//	@Select("<script>"+"SELECT\r\n" + 
//			"			A.NAMEI1 WNAMEI, A.IDNUMB WIDNUM, B.SPNRNAM1, A.NATIMK WNATMK, B.CNTCOD, B.CNTNAM, A.BRIDAT WBIDAT, A.MKSEXS WMKSEX, A.MARRID WMARRI,\r\n" + 
//			"			A.ADREN1 WADREN, A.MAILAD WMAILA, A.ADRENO ZIPCOD, A.ADDRES WADDRE, A.TELNO2 WTELN2, A.TELNO1 WTELN1, A.TELNO3 WTELN3, B.EMAIL, B.JOBNO, B.RELTIN,\r\n" + 
//			"			B.GETNAM, B.GETIDN, B.SPNRNAM2, B.GETNAT, B.GETCNTC, B.GETCNTN, B.GETBRI, B.GETSEX, B.GETANO, B.GETADD, B.GETTEL\r\n" + 
//			"		FROM\r\n" + 
//			"			AXPOPF1 A JOIN CUSTPF1 B\r\n" + 
//			"			ON A.POLYN2 = B.PONO99\r\n" + 
//			"		<where>\r\n" + 
//			"			<if test=\"polyn1 != null and polyn1 != ''\">\r\n" + 
//			"			A.POLYN1 = #{polyn1,jdbcType=CHAR}\r\n" + 
//			"			</if>\r\n" + 
//			"			<if test=\"polyn2 != null and polyn2 != ''\">\r\n" + 
//			"			AND A.POLYN2 = #{polyn2,jdbcType=CHAR}\r\n" + 
//			"			</if>\r\n" + 
//			"		</where>\r\n" + 
//			"			ORDER BY B.UPDDAT DESC LIMIT 1"+ "</script>")
//	List<PolicyChangeInside> queryAxInsideData002_1 (@Param("polyn1") String polyn1, @Param("polyn2") String polyn2);
//	
//	/**
//	 *  查詢強制  業務來源/其它
//	 * @param yendnw
//	 * @param polyn1
//	 * @param polyn2
//	 * @return
//	 * @throws Exception 
//	 */
//	@Select("<script>"+"SELECT\r\n" + 
//			"			A.INSSRC, A.SALDEP, B.PROJEC, B.CAMPCD,A.SOLIN1, A.SOLIN2, A.SALCOD, A.SALNAM,\r\n" + 
//			"			B.BKCOD1, B.PIDNUM, B.PNAMEI, B.BKCOD2, B.PIDNUM2, B.PNAMEI2, B.ACCEPTNO\r\n" + 
//			"		FROM\r\n" + 
//			"			AXENPF1 A JOIN CUSTPF1 B\r\n" + 
//			"			ON A.YENDNO = B.YENDNW\r\n" + 
//			"		<where>\r\n" + 
//			"			<if test=\"yendnw != null and yendnw != ''\">\r\n" + 
//			"				B.YENDNW = #{yendnw,jdbcType=CHAR}\r\n" + 
//			"			</if>\r\n" + 
//			"			<if test=\"polyn1 != null and polyn1 != ''\">\r\n" + 
//			"			AND A.POLYN1 = #{polyn1,jdbcType=CHAR}\r\n" + 
//			"			</if>\r\n" + 
//			"			<if test=\"polyn2 != null and polyn2 != ''\">\r\n" + 
//			"			AND A.POLYN2 = #{polyn2,jdbcType=CHAR}\r\n" + 
//			"			</if>\r\n" + 
//			"		</where>\r\n" + 
//			"			ORDER BY B.UPDDAT DESC LIMIT 1"+ "</script>")
//	List<PolicyChangeInside> queryAxInsideData004(@Param("yendnw") String yendnw, @Param("polyn1") String polyn1,
//			@Param("polyn2") String polyn2);
//
//	/**
//	 * 查詢強制  業務來源/其它
//	 * @param polyn1
//	 * @param polyn2
//	 * @return
//	 * @throws Exception
//	 */
//	@Select("<script>"+"SELECT\r\n" + 
//			"			A.INSSRC, A.SALDEP, B.PROJEC, B.CAMPCD,A.SOLIN1, A.SOLIN2, A.SALCOD, A.SALNAM,\r\n" + 
//			"			B.BKCOD1, B.PIDNUM, B.PNAMEI, B.BKCOD2, B.PIDNUM2, B.PNAMEI2, B.ACCEPTNO\r\n" + 
//			"		FROM\r\n" + 
//			"			AXPOPF1 A JOIN CUSTPF1 B\r\n" + 
//			"			ON A.POLYN2 = B.PONO99\r\n" + 
//			"		<where>\r\n" + 
//			"			<if test=\"polyn1 != null and polyn1 != ''\">\r\n" + 
//			"			A.POLYN1 = #{polyn1,jdbcType=CHAR}\r\n" + 
//			"			</if>\r\n" + 
//			"			<if test=\"polyn2 != null and polyn2 != ''\">\r\n" + 
//			"			AND A.POLYN2 = #{polyn2,jdbcType=CHAR}\r\n" + 
//			"			</if>\r\n" + 
//			"		</where>\r\n" + 
//			"			ORDER BY B.UPDDAT DESC LIMIT 1"+ "</script>")
//	List<PolicyChangeInside> queryAxInsideData004_1(@Param("polyn1") String polyn1, @Param("polyn2") String polyn2);
//	
//	@Select("<script>" + "SELECT \r\n" + 
//			"			  A.REASON, A.APPLNO, A.YENDNO, A.CRTDAT, A.OPRNUM, A.YENPRO, A.ENVDAT, A.PRTDAT, A.YRETIM, \r\n" + 
//			"			  B.RPAY_COND rpaycond, A.AUTPRO, A.MONCHK, A.WINDAT, A.WEXDAT, A.WMONTH, B.epomak, \r\n" + 
//			"			  A.ACCOPR, B.CHKOPR1, B.CHKOPR2, B.CHKOPR3,\r\n" + 
//			"			  A.WNAMEI, A.WNAMMK, A.WIDNUM, B.SPNRNAM1, A.WNATMK, B.CNTCOD, B.CNTNAM, A.WBIDAT, A.WMKSEX, A.WMARRI,\r\n" + 
//			"			  A.WADREN, A.WMAILA, A.ZIPCOD, A.WADDRE, A.WTELN2, A.WTELN1, A.WTELN3, B.EMAIL, B.JOBNO, B.RELTIN, B.RELTINDES,\r\n" + 
//			"			  B.GETNAM, B.GETIDN, B.SPNRNAM2, B.GETNAT, B.GETCNTC, B.GETCNTN, B.GETBRI, B.GETSEX, B.GETANO, B.GETADD, B.GETTEL,\r\n" + 
//			"			  A.INSSRC, A.SALDEP, B.PROJEC, B.CAMPCD,A.SOLIN1, A.SOLIN2, A.SALCOD, A.SALNAM,\r\n" + 
//			"			  B.BKCOD1, B.PIDNUM, B.PNAMEI, B.BKCOD2, B.PIDNUM2, B.PNAMEI2, B.ACCEPTNO\r\n" + 
//			"			  FROM AFENTEMP A JOIN CUSTEMP B ON A.APPLNO = B.APPLNO AND B.CHANGE_TYPE = 'f' \r\n" + 
//			"			  WHERE 1=1 \r\n" + 
//			"			  <if test='applno != null and applno != \"\"'>\r\n" + 
//			"			  AND A.APPLNO = #{applno} \r\n" + 
//			"			  </if>\r\n" + 
//			"			  ORDER BY B.UPDDAT DESC \r\n" + 
//			"			  LIMIT 1 "+ "</script>")
//	List<PolicyChangeInside> insCreateInsidefModifiedDAO(@Param("applno") String applno);
//	
//	@Select("<script>" + "SELECT \r\n" + 
//			"			 A.REASON, A.APPLNO, A.YENDNO, A.CRTDAT, A.OPRNUM, A.YENPRO, A.ENVDAT, A.PRTDAT, A.PRTTIM yretim, \r\n" + 
//			"			 B.RPAY_COND rpaycond, A.AUTPRO, A.MONCHK, A.WINDAT, A.WEXDAT, A.WMONTH, B.epomak, \r\n" + 
//			"			 A.ACCOPR, B.CHKOPR1, B.CHKOPR2, B.CHKOPR3, B.GETTEL,\r\n" + 
//			"			 A.WNAME1 wnamei, A.WNAMMK, A.WIDNUM, B.SPNRNAM1, A.WNATMK, B.CNTCOD, B.CNTNAM,\r\n" + 
//			"			 A.WBRDAT wbidat, A.WMKSEX, A.WMARRI, A.WZIPCO wadren, A.WMAILA, A.ZIPCOD, A.WADDRE, A.WTENO2 wteln2, A.WTENO1 wteln1, A.WTENO3 wteln3,\r\n" + 
//			"			 B.EMAIL, B.JOBNO, B.RELTIN, B.RELTINDES, B.GETNAM, B.GETIDN, B.SPNRNAM2, B.GETNAT, B.GETCNTC, B.GETCNTN, B.GETJOB, \r\n" + 
//			"			 B.GETBRI, B.GETSEX, B.GETANO, B.GETADD, B.GETTEL,\r\n" + 
//			"			 A.INSSRC, A.SALDEP, B.PROJEC, B.CAMPCD,A.SOLIN1, A.SOLIN2, A.SALCOD, A.SALNAM,\r\n" + 
//			"			 B.BKCOD1, B.PIDNUM, B.PNAMEI, B.BKCOD2, B.PIDNUM2, B.PNAMEI2, B.ACCEPTNO,   \r\n" + 
//			"			 A.COMTYP1, A.COMTYP2, A.COMSTK2, B.MOVMAK   \r\n" + 
//			"			 FROM AXENTEMP A JOIN CUSTEMP B ON A.APPLNO = B.APPLNO AND B.CHANGE_TYPE = 'h' \r\n" + 
//			"			 WHERE 1=1 \r\n" + 
//			"			 <if test='applno != null and applno != \"\"'>\r\n" + 
//			"			 AND A.APPLNO = #{applno} \r\n" + 
//			"			 </if> \r\n" + 
//			"			 ORDER BY B.UPDDAT DESC \r\n" + 
//			"			 LIMIT 1 "+ "</script>")
//	List<PolicyChangeInside> insCreateInsidexModifiedDAO(@Param("applno") String applno);
//	
//	/**
//	 * 批改申請單號查詢強制 保/批單資料
//	 * @param yendnw
//	 * @param fcerno
//	 * @return
//	 */
//	@Select("<script>"
//			 + "SELECT "
//			 + "A.APPLNO, A.YENDNO, A.CRTDAT, A.OPRNUM, A.YENPRO, A.ENVDAT, A.PRTDAT, A.YRETIM, "
//			 + "A.BUILDNO, A.BUILDMEM, A.BUILDDATE, "
//			 + "B.RPAY_COND, A.AUTPRO, A.MONCHK, A.WINDAT, A.WEXDAT, A.WMONTH, B.epomak, "
//			 + "A.WUSERN, A.WBENEN, "
//			 + "A.ACCOPR, B.CHKOPR1, B.CHKOPR2, B.CHKOPR3 "
//			 + "FROM AFENTEMP A JOIN CUSTEMP B ON A.APPLNO = B.APPLNO AND B.CHANGE_TYPE = 'f' "
//			 + "WHERE 1=1 "
//			 + "<if test='applno != null and applno != \"\"'>"
//			 + "AND A.APPLNO = #{applno} "
//			 + "</if>"
//			 + "ORDER BY B.UPDDAT DESC "
//			 + "LIMIT 1 "
//			 + "</script>")
//	List<PolicyChangeInside> insCreateInsidef001(@Param("applno") String applno);
//	
//	/**
//	 * 批改申請單號查詢任意 保/批單資料
//	 * @param yendnw
//	 * @param fcerno
//	 * @return
//	 */
//	@Select("<script>"
//			+ "SELECT "
//			+ "A.APPLNO, A.YENDNO, A.CRTDAT, A.OPRNUM, A.YENPRO, A.ENVDAT, A.PRTDAT, A.PRTTIM yretim, "
//			+ "A.BUILDNO, A.BUILDMEM, A.BUILDDATE, "
//			+ "B.RPAY_COND, A.AUTPRO, A.MONCHK, A.WINDAT, A.WEXDAT, A.WMONTH, B.epomak, "
//			 + "A.WUSERN, A.WBENEN, "
//			+ "A.ACCOPR, B.CHKOPR1, B.CHKOPR2, B.CHKOPR3, B.GETTEL "
//			+ "FROM AXENTEMP A JOIN CUSTEMP B ON A.APPLNO = B.APPLNO AND B.CHANGE_TYPE = 'h' "
//			+ "WHERE 1=1 "
//			+ "<if test='applno != null and applno != \"\"'>"
//			+ "AND A.APPLNO = #{applno} "
//			+ "</if> "
//			+ "ORDER BY B.UPDDAT DESC "
//			+ "LIMIT 1 "
//			+ "</script>")
//	List<PolicyChangeInside> insCreateInsidex001(@Param("applno") String applno);
//	
//	/**
//	 * 查詢強制 車主資料-要被保險人
//	 * @param applno
//	 * @return
//	 */
//	@Select("<script>"
//			+ "SELECT "
//			+ "A.WNAMEI, A.WNAMMK, A.WIDNUM, B.SPNRNAM1, A.WNATMK, B.CNTCOD, B.CNTNAM, A.WBIDAT, A.WMKSEX, A.WMARRI, "
//			+ "A.WADREN, A.WMAILA, A.ZIPCOD, A.WADDRE, A.WTELN2, A.WTELN1, A.WTELN3, B.EMAIL, B.JOBNO, B.RELTIN, B.RELTINDES, "
//			+ "B.GETNAM, B.GETIDN, B.SPNRNAM2, B.GETNAT, B.GETCNTC, B.GETCNTN, B.GETBRI, B.GETSEX, B.GETANO, B.GETADD, B.GETTEL "
//			+ "FROM AFENTEMP A JOIN CUSTEMP B ON A.APPLNO = B.APPLNO AND B.CHANGE_TYPE = 'f' "
//			+ "WHERE 1=1 "
//			+ "<if test='applno != null and applno != \"\"'>"
//			+ "AND A.APPLNO = #{applno} "
//			+ "</if>"
//			+ "ORDER BY B.UPDDAT DESC "
//			+ "LIMIT 1 "
//			+ "</script>")
//	List<PolicyChangeInside> insCreateInsidef002(@Param("applno") String applno);
//	
//	/**
//	 * 查詢任意車主資料-要被保險人
//	 * @param applno
//	 * @return
//	 */
//	@Select("<script>"
//			+ "SELECT "
//			+ "A.WNAME1 wnamei, A.WNAMMK, A.WIDNUM, B.SPNRNAM1, A.WNATMK, B.CNTCOD, B.CNTNAM, "
//			+ "A.WBRDAT wbidat, A.WMKSEX, A.WMARRI, A.WZIPCO, A.WMAILA, A.ZIPCOD, A.WADDRE, A.WTENO2 wteln2, A.WTENO1 wteln1, A.WTENO3 wteln3, "
//			+ "B.EMAIL, B.JOBNO, B.RELTIN, B.GETNAM, B.GETIDN, B.SPNRNAM2, B.GETNAT, B.GETCNTC, B.GETCNTN, "
//			+ "B.GETBRI, B.GETSEX, B.GETANO, B.GETADD, B.GETTEL "
//			+ "FROM AXENTEMP A JOIN CUSTEMP B ON A.APPLNO = B.APPLNO AND B.CHANGE_TYPE = 'h' "
//			+ "WHERE 1=1 "
//			+ "<if test='applno != null and applno != \"\"'>"
//			+ "AND A.APPLNO = #{applno} "
//			+ "</if>"
//			+ "ORDER BY B.UPDDAT DESC "
//			+ "LIMIT 1 "
//			+ "</script>")
//	List<PolicyChangeInside> insCreateInsidex002(@Param("applno") String applno);
//	
//	/**
//	 * 查詢強制  業務來源/其它
//	 * @param applno
//	 * @return
//	 */
//	@Select("<script>"
//			+ "SELECT "
//			+ "A.INSSRC, A.SALDEP, B.PROJEC, B.CAMPCD,A.SOLIN1, A.SOLIN2, A.SALCOD, A.SALNAM, "
//			+ "B.BKCOD1, B.PIDNUM, B.PNAMEI, B.BKCOD2, B.PIDNUM2, B.PNAMEI2, B.ACCEPTNO "
//			+ "FROM AXENTEMP A JOIN CUSTEMP B ON A.APPLNO = B.APPLNO AND B.CHANGE_TYPE = 'f' "
//			+ "WHERE 1=1 "
//			+ "<if test='applno != null and applno != \"\"'>"
//			+ "AND A.APPLNO = #{applno} "
//			+ "</if>"
//			+ "ORDER BY B.UPDDAT DESC "
//			+ "LIMIT 1 "
//			+ "</script>")
//	List<PolicyChangeInside> insCreateInsidef004(@Param("applno") String applno);
//	
//	/**
//	 * 查詢任意  業務來源/其它
//	 * @param applno
//	 * @return
//	 */
//	@Select("<script>"
//			+ "SELECT "
//			+ "A.INSSRC, A.SALDEP, B.PROJEC, B.CAMPCD,A.SOLIN1, A.SOLIN2, A.SALCOD, A.SALNAM, "
//			+ "B.BKCOD1, B.PIDNUM, B.PNAMEI, B.BKCOD2, B.PIDNUM2, B.PNAMEI2, B.ACCEPTNO "
//			+ "FROM AXENTEMP A JOIN CUSTEMP B ON A.APPLNO = B.APPLNO AND B.CHANGE_TYPE = 'h' "
//			+ "WHERE 1=1 "
//			+ "<if test='applno != null and applno != \"\"'>"
//			+ "AND A.APPLNO = #{applno} "
//			+ "</if>"
//			+ "ORDER BY B.UPDDAT DESC "
//			+ "LIMIT 1 "
//			+ "</script>")
//	List<PolicyChangeInside> insCreateInsidex004(@Param("applno") String applno);
//	
//	/**
//	 * 查詢強制批單延伸檔
//	 * @param applno
//	 * @return
//	 */
//	@Select("<script>" + "SELECT APPLNO,BUILDNO,ELEAPPRMK,SURCARMK,OUTMAK,LEGREP,"
//			+ "FAX,GETMKIDEN,MARRID,GETLEGREP,RELICENSE,USEMK,FACTVER,"
//			+ "CHANNEL_TYPE CHANNELTYPE,STADAT,OCOMM,WCOMM,RECOMMISSION,GETMK,DIRNAM,BLTERR,"
//			+ "BLPOLI,BLGRUP,VEHCON,HIGHPRICE,COSTCHECK,COMMNO,COMMISSION," + "PAYCOMMDAT,VERIREASON,VERIMSG "
//			+ "FROM AFENCUST " + "WHERE 1=1 " + "<if test='applno != null and applno != \"\"'>"
//			+ "AND APPLNO = #{applno} " + "</if>" + "</script>")
//	List<Afencust> insCreateInsideAfencust(@Param("applno") String applno);
//	
//	/**
//	 * 查詢任意批單延伸檔
//	 * @param applno
//	 * @return
//	 */
//	@Select("<script>" + "SELECT APPLNO,BUILDNO,ELEAPPRMK,SURCARMK,OUTMAK,LEGREP,FAX,GETMKIDEN,"
//			+ "MARRID,GETLEGREP,RELICENSE,USEMK,FACTVER,CHANNEL_TYPE CHANNELTYPE,STADAT,OCOMM,WCOMM,"
//			+ "RECOMMISSION,GETMK,DIRNAM,BLTERR,BLPOLI,BLGRUP,VEHCON,HIGHPRICE,COSTCHECK,"
//			+ "COMMNO,COMMISSION,PAYCOMMDAT,VERIREASON,VERIMSG" + " FROM AXENCUST " + "WHERE 1=1 "
//			+ "<if test='applno != null and applno != \"\"'>" + "AND APPLNO = #{applno} " + "</if>" + "</script>")
//	List<Axencust> insCreateInsideAxencust(@Param("applno") String applno);
//	
//	/**
//	 * 查詢changelog Table
//	 * @param applno
//	 * @param changetype
//	 * @return
//	 */
//	@Select("SELECT * "
//			+ "FROM CHANGELOG "
//			+ "WHERE APPLNO = #{applno} "
//			+ "AND CHANGE_TYPE = #{changetype} "
//			+ "ORDER BY CRTDAT DESC "
//			+ "LIMIT 1")
//	List<Changelog> queryChangelog(@Param("applno") String applno, @Param("changetype") String changetype);
//	
//	/**
//	 * 修改changelog Table
//	 * @param applno
//	 * @param changetype
//	 * @param buildno
//	 * @return
//	 */
//	@Update("UPDATE CHANGELOG "
//			+ "SET BUILDNO = #{buildno} "
//			+ "WHERE ID = #{id}")
//	int updateChangelogBuildno(@Param("buildno") String buildno, @Param("id") Integer id);
//	
//	//批單建檔查詢 強制
//	@Select("<script>"
//			+ "SELECT "
//			+ "A.APPLNO APPLNO, A.FCERNO POLYN2, A.YENDNO YENDNO, A.WNAMEI WNAME1"
//			+ ", A.GETNAM GETNAM, A.WIDNUM WIDNUM, A.GETIDN GETIDN, A.WLICNO WLICNO"
//			+ ", A.WINDAT WINDAT, A.WEXDAT WEXDAT, A.YENPRO YENPRO , A.ENVDAT, A.BUILDMEM"
//			+ ", A.STATUS STATUS, C.STMSG STMSG "
//			+ "FROM AFENTEMP A JOIN STATUS_MSG C ON A.STATUS = C.STCODE AND A.MSGTYPE = C.MSGTYPE "
//			+ "WHERE 1=1"
//			+ "<if test=\"upddat_start != null\">"
//			+ "AND A.UPDDAT &gt;= #{upddat_start,jdbcType=DATE} "
//			+ "</if>"
//			+ "<if test=\"upddat_end != null\">"
//			+ "AND A.UPDDAT &lt;= #{upddat_end,jdbcType=DATE} "
//			+ "</if>"
//			+ "<if test=\"fcerno != null and fcerno != ''\">"
//			+ "AND A.FCERNO = #{fcerno,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test=\"applno != null and applno != ''\">"
//			+ "AND A.APPLNO = #{applno,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"wlicno != null and wlicno != ''\">"
//			+ "AND A.WLICNO = #{wlicno,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"widnum != null and widnum != ''\">"
//			+ "AND A.WIDNUM = #{widnum,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"getidn != null and getidn != ''\">"
//			+ "AND A.GETIDN = #{getidn,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"buildmem != null and buildmem != ''\">"
//			+ "AND A.BUILDMEM = #{buildmem,jdbcType=CHAR} "
//			+ "</if>"
//			+ "AND A.MSGTYPE = '1'"
//			+ "ORDER BY A.UPDDAT DESC"
//			+ "</script>")
//	List<InsBulidQueryTable> queryAfBuildJoinTable(@Param("upddat_start") Date upddat_start, @Param("upddat_end") Date upddat_end, 
//			@Param("buildmem") String buildmem, @Param("fcerno") String fcerno, @Param("applno") String applno,
//			@Param("wlicno") String wlicno, @Param("widnum") String widnum, @Param("getidn") String getidn);
//	
//	//建檔審核 強制
//	@Select("<script>"
//			+ "SELECT "
//			+ "A.APPLNO APPLNO, A.FCERNO POLYN2, A.YENDNO YENDNO, A.WNAMEI WNAME1, A.BUILDMEM, A.BUILDDATE"
//			+ ", A.GETNAM GETNAM, A.WIDNUM WIDNUM, A.GETIDN GETIDN, A.WLICNO WLICNO"
//			+ ", A.WINDAT WINDAT, A.WEXDAT WEXDAT, A.YENPRO YENPRO, A.STATUS STATUS, C.STMSG STMSG "
//			+ "FROM AFENTEMP A JOIN STATUS_MSG C ON A.STATUS = C.STCODE AND A.MSGTYPE = C.MSGTYPE "
//			+ "WHERE 1=1"
//			+ "<if test=\"upddat_start != null\">"
//			+ "AND A.UPDDAT &gt;= #{upddat_start,jdbcType=DATE} "
//			+ "</if>"
//			+ "<if test=\"upddat_end != null\">"
//			+ "AND A.UPDDAT &lt;= #{upddat_end,jdbcType=DATE} "
//			+ "</if>"
//			+ "<if test=\"fcerno != null and fcerno != ''\">"
//			+ "AND A.FCERNO = #{fcerno,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test=\"applno != null and applno != ''\">"
//			+ "AND A.APPLNO = #{applno,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"wlicno != null and wlicno != ''\">"
//			+ "AND A.WLICNO = #{wlicno,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"widnum != null and widnum != ''\">"
//			+ "AND A.WIDNUM = #{widnum,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"getidn != null and getidn != ''\">"
//			+ "AND A.GETIDN = #{getidn,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"buildmem != null and buildmem != ''\">"
//			+ "AND A.BUILDMEM = #{buildmem,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"status == 1\">"
//			+ "AND A.STATUS NOT IN ('26')"
//			+ "</if>"
//			+ "<if test=\"status == 2\">"
//			+ "AND A.STATUS = '26'"
//			+ "</if>"
//			+ "AND A.MSGTYPE = '1'"
//			+ "ORDER BY A.UPDDAT DESC"
//			+ "</script>")
//	List<InsBulidQueryTable> queryAfInsEndorseCheck(@Param("upddat_start") Date upddat_start, @Param("upddat_end") Date upddat_end, 
//			@Param("buildmem") String buildmem, @Param("fcerno") String fcerno, @Param("applno") String applno,
//			@Param("wlicno") String wlicno, @Param("widnum") String widnum, @Param("getidn") String getidn, @Param("status") String status);
//	
//	//批單建檔查詢 任意
//	@Select("<script>"
//			+ "SELECT "
//			+ "A.APPLNO APPLNO, A.POLYN1 POLYN1, A.POLYN2 POLYN2, A.OBJENO OBJENO, A.YENDNO YENDNO, A.WNAME1 WNAME1"
//			+ ", A.GETNAM GETNAM, A.WIDNUM WIDNUM, A.GETIDN GETIDN, A.WLICNO WLICNO"
//			+ ", A.WINDAT WINDAT, A.WEXDAT WEXDAT, A.YENPRO YENPRO, A.ENVDAT, A.BUILDMEM"
//			+ ", A.STATUS STATUS, C.STMSG STMSG "
//			+ "FROM AXENTEMP A JOIN STATUS_MSG C ON A.STATUS = C.STCODE AND A.MSGTYPE = C.MSGTYPE "
//			+ "WHERE 1=1 "
//			+ "<if test=\"upddat_start != null\">"
//			+ "AND A.UPDDAT &gt;= #{upddat_start,jdbcType=DATE} "
//			+ "</if>"
//			+ "<if test=\"upddat_end != null\">"
//			+ "AND A.UPDDAT &lt;= #{upddat_end,jdbcType=DATE} "
//			+ "</if>"
//			+ "<if test=\"polyn1 != null and polyn1 != ''\">"
//			+ "AND A.POLYN1 = #{polyn1,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"polyn2 != null and polyn2 != ''\">"
//			+ "AND A.POLYN2 = #{polyn2,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"objeno != null\">"
//			+ "AND A.OBJENO = #{objeno,jdbcType=SMALLINT} "
//			+ "</if>"
//			+ "<if test=\"applno != null and applno != ''\">"
//			+ "AND A.APPLNO = #{applno,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"wlicno != null and wlicno != ''\">"
//			+ "AND A.WLICNO = #{wlicno,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"widnum != null and widnum != ''\">"
//			+ "AND A.WIDNUM = #{widnum,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"getidn != null and getidn != ''\">"
//			+ "AND A.GETIDN = #{getidn,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"buildmem != null and buildmem != ''\">"
//			+ "AND A.BUILDMEM = #{buildmem,jdbcType=CHAR} "
//			+ "</if>"
//			+ "AND A.MSGTYPE = '1'"
//			+ "ORDER BY A.UPDDAT DESC"
//			+ "</script>")
//	List<InsBulidQueryTable> queryAxBuildJoinTable(@Param("upddat_start") Date upddat_start, @Param("upddat_end") Date upddat_end, 
//			@Param("buildmem") String buildmem, 
//			@Param("polyn1") String polyn1, @Param("polyn2") String polyn2, @Param("objeno") Short objeno,
//			@Param("applno") String applno, @Param("wlicno") String wlicno, 
//			@Param("widnum") String widnum, @Param("getidn") String getidn);
//	
//	//建檔審核 任意
//	@Select("<script>"
//			+ "SELECT "
//			+ "A.APPLNO APPLNO, A.POLYN1 POLYN1, A.POLYN2 POLYN2, A.OBJENO OBJENO, A.YENDNO YENDNO, A.WNAME1 WNAME1, A.BUILDMEM, A.BUILDDATE"
//			+ ", A.GETNAM GETNAM, A.WIDNUM WIDNUM, A.GETIDN GETIDN, A.WLICNO WLICNO"
//			+ ", A.WINDAT WINDAT, A.WEXDAT WEXDAT, A.YENPRO YENPRO, A.STATUS STATUS, C.STMSG STMSG "
//			+ "FROM AXENTEMP A JOIN STATUS_MSG C ON A.STATUS = C.STCODE AND A.MSGTYPE = C.MSGTYPE "
//			+ "WHERE 1=1 "
//			+ "<if test=\"upddat_start != null\">"
//			+ "AND A.UPDDAT &gt;= #{upddat_start,jdbcType=DATE} "
//			+ "</if>"
//			+ "<if test=\"upddat_end != null\">"
//			+ "AND A.UPDDAT &lt;= #{upddat_end,jdbcType=DATE} "
//			+ "</if>"
//			+ "<if test=\"polyn1 != null and polyn1 != ''\">"
//			+ "AND A.POLYN1 = #{polyn1,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"polyn2 != null and polyn2 != ''\">"
//			+ "AND A.POLYN2 = #{polyn2,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"objeno != null\">"
//			+ "AND A.OBJENO = #{objeno,jdbcType=SMALLINT} "
//			+ "</if>"
//			+ "<if test=\"applno != null and applno != ''\">"
//			+ "AND A.APPLNO = #{applno,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"wlicno != null and wlicno != ''\">"
//			+ "AND A.WLICNO = #{wlicno,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"widnum != null and widnum != ''\">"
//			+ "AND A.WIDNUM = #{widnum,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"getidn != null and getidn != ''\">"
//			+ "AND A.GETIDN = #{getidn,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"buildmem != null and buildmem != ''\">"
//			+ "AND A.BUILDMEM = #{buildmem,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test=\"status == 1\">"
//			+ "AND A.STATUS NOT IN ('26')"
//			+ "</if>"
//			+ "<if test=\"status == 2\">"
//			+ "AND A.STATUS = '26'"
//			+ "</if>"
//			+ "AND A.MSGTYPE = '1'"
//			+ "ORDER BY A.UPDDAT DESC"
//			+ "</script>")
//	List<InsBulidQueryTable> queryAxInsEndorseCheck(@Param("upddat_start") Date upddat_start, @Param("upddat_end") Date upddat_end, 
//			@Param("buildmem") String buildmem,
//			@Param("polyn1") String polyn1, @Param("polyn2") String polyn2, @Param("objeno") Short objeno,
//			@Param("fcerno") String fcerno, @Param("applno") String applno, @Param("wlicno") String wlicno, 
//			@Param("widnum") String widnum, @Param("getidn") String getidn, @Param("status") String status);
//		
//	//再保確認作業查詢_強制
//	@Select("<script>"
//			+ "SELECT "
//			+ "APPLNO,FCERNO,WNAMEI,WIDNUM,WLICNO,YENPRO,ENVDAT,GETNAM,GETIDN,CHKINOUT "
//			+ "FROM AFENTEMP "
//			+ "<where>"
//			+ "<if test='fcerno != null and fcerno != \"\"'>"
//			+ "FCERNO = #{fcerno,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test='widnum != null and widnum != \"\"'>"
//			+ "AND WIDNUM = #{widnum,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test='wlicno != null and wlicno != \"\"'>"
//			+ "AND WLICNO = #{wlicno,jdbcType=CHAR} "
//			+ "</if>"
//			+ "</where>"
//			+ "</script>")
//	List<ReinsureCheckTable> AfReinsureCheckQuery(@Param("fcerno") String fcerno, @Param("widnum") String widnum, @Param("wlicno") String wlicno);
//	
//	//再保確認作業查詢_任意
//	@Select("<script>"
//			+ "SELECT "
//			+ "APPLNO,POLYN2 fcerno,WNAME1 wnamei,WIDNUM,WLICNO,YENPRO,ENVDAT,GETNAM,GETIDN,CHKINOUT "
//			+ "FROM AXENTEMP "
//			+ "<where>"
//			+ "<if test='fcerno != null and fcerno != \"\"'>"
//			+ "POLYN2 = #{fcerno,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test='widnum != null and widnum != \"\"'>"
//			+ "AND WIDNUM = #{widnum,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test='wlicno != null and wlicno != \"\"'>"
//			+ "AND WLICNO = #{wlicno,jdbcType=CHAR} "
//			+ "</if>"
//			+ "</where>"
//			+ "</script>")
//	List<ReinsureCheckTable> AxReinsureCheckQuery(@Param("fcerno") String fcerno, @Param("widnum") String widnum, @Param("wlicno") String wlicno);
//
//	//再保確認作業_強制審核和查詢
//	@Select("<script>"
//			 + "SELECT "
//			 + "A.APPLNO, A.YENDNO, A.CRTDAT, A.OPRNUM, A.YENPRO, A.ENVDAT, A.PRTDAT, A.YRETIM, "
//			 + "B.RPAY_COND, A.AUTPRO, A.MONCHK, A.WINDAT, A.WEXDAT, A.WMONTH, B.EPOMAK, "
//			 + "A.ACCOPR, B.CHKOPR1, B.CHKOPR2, B.CHKOPR3, A.BUILDDATE, A.BUILDMEM "
//			 + "FROM AFENTEMP A JOIN CUSTEMP B ON A.APPLNO = B.APPLNO AND B.CHANGE_TYPE = 'f' "
//			 + "WHERE 1=1 "
//			 + "<if test='applno != null and applno != \"\"'>"
//			 + "AND A.APPLNO = #{applno} "
//			 + "</if>"
//			 + "<if test='fcerno != null and fcerno != \"\"'>"
//			 + "AND A.FCERNO = #{fcerno} "
//			 + "</if>"
//			 + "ORDER BY B.UPDDAT DESC "
//			 + "LIMIT 1 "
//			 + "</script>")
//	List<PolicyChangeInside> reinsureCheckInsidef001(@Param("applno") String applno, @Param("fcerno") String fcerno);
//	
//	//再保確認作業_任意審核和查詢
//	@Select("<script>"
//			+ "SELECT "
//			+ "A.APPLNO, A.YENDNO, A.CRTDAT, A.OPRNUM, A.YENPRO, A.ENVDAT, A.PRTDAT, A.PRTTIM yretim, "
//			+ "B.RPAY_COND, A.AUTPRO, A.MONCHK, A.WINDAT, A.WEXDAT, A.WMONTH, B.EPOMAK, "
//			+ "A.ACCOPR, B.CHKOPR1, B.CHKOPR2, B.CHKOPR3, B.GETTEL, A.BUILDDATE, A.BUILDMEM  "
//			+ "FROM AXENTEMP A JOIN CUSTEMP B ON A.APPLNO = B.APPLNO AND B.CHANGE_TYPE = 'h' "
//			+ "WHERE 1=1 "
//			+ "<if test='applno != null and applno != \"\"'>"
//			+ "AND A.APPLNO = #{applno} "
//			+ "</if> "
//			+ "<if test='fcerno != null and fcerno != \"\"'>"
//			+ "AND A.POLYN2 = #{fcerno} "
//			+ "</if> "
//			+ "ORDER BY B.UPDDAT DESC "
//			+ "LIMIT 1 "
//			+ "</script>")
//	List<PolicyChangeInside> reinsureCheckInsidex001(@Param("applno") String applno, @Param("fcerno") String fcerno);
//
//	// 報價單位查詢-大地區
//	@Select("SELECT DISTINCT DEPTWN, DEPTWN_NAME DEPTWNNAME FROM DEPTCODE ORDER BY DEPTWN")
//	List<Deptcode> queryDeptcode();
//
//	@Select("<script>"+"select\r\n" + 
//			"	  A.APPLNO APPLNO\r\n" + 
//			"	  , A.POLYN2 POLYN2\r\n" + 
//			"	  , A.OPRNUM OPRNUM\r\n" + 
//			"	  , A.WNAME1 WNAME1\r\n" + 
//			"	  , A.GETNAM GETNAM\r\n" + 
//			"	  , A.WIDNUM WIDNUM\r\n" + 
//			"	  , A.GETIDN GETIDN\r\n" + 
//			"	  , A.WLICNO WLICNO\r\n" + 
//			"	  , A.WINDAT WINDAT\r\n" + 
//			"	  , A.WEXDAT WEXDAT\r\n" + 
//			"	  , A.YENPRO YENPRO\r\n" + 
//			"	  , A.ENVDAT ENVDAT\r\n" + 
//			"	  , A.STATUS STATUS\r\n" + 
//			"	  , C.STMSG STMSG\r\n" + 
//			"	FROM\r\n" + 
//			"	  AXENTEMP A JOIN STATUS_MSG C\r\n" + 
//			"	    ON A.STATUS = C.STCODE AND A.MSGTYPE = C.MSGTYPE\r\n" + 
//			"		WHERE 1=1\r\n" + 
//			"		<if test=\"upddat_start != null\">\r\n" + 
//			"		AND A.UPDDAT &gt;= #{upddat_start,jdbcType=TIMESTAMP}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"upddat_end != null\">\r\n" + 
//			"		AND A.UPDDAT &lt;= #{upddat_end,jdbcType=TIMESTAMP}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"polyn1 != null and polyn1 != ''\">\r\n" + 
//			"		and A.POLYN1 = #{polyn1,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"polyn2 != null and polyn2 != ''\">\r\n" + 
//			"		and A.POLYN2 = #{polyn2,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"oprnum != null and oprnum != ''\">\r\n" + 
//			"		and A.OPRNUM = #{oprnum,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"objeno != null\">\r\n" + 
//			"		and A.OBJENO = #{objeno,jdbcType=SMALLINT},\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"fcerno != null and fcerno != ''\">\r\n" + 
//			"		AND A.FCERNO = #{fcerno,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"applno != null and applno != ''\">\r\n" + 
//			"		AND A.APPLNO = #{applno,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"wlicno != null and wlicno != ''\">\r\n" + 
//			"		AND A.WLICNO = #{wlicno,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"widnum != null and widnum != ''\">\r\n" + 
//			"		AND A.WIDNUM = #{widnum,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"getidn != null and getidn != ''\">\r\n" + 
//			"		AND A.GETIDN = #{getidn,jdbcType=CHAR}\r\n" + 
//			"		</if>"+
//			"		AND C.MSGTYPE = '0'" + "</script>")
//	List<PolicyChangeApplQueryTable> queryAxentempJoinTable(@Param("upddat_start") Date upddat_start,
//			@Param("upddat_end") Date upddat_end, @Param("polyn1") String polyn1, @Param("polyn2") String polyn2, @Param("oprnum") String oprnum,
//			@Param("objeno") Short objeno, @Param("fcerno") String fcerno, @Param("applno") String applno,
//			@Param("wlicno") String wlicno, @Param("widnum") String widnum, @Param("getidn") String getidn);
//
//	@Select("<script>"+"select\r\n" + 
//			"	  A.APPLNO APPLNO\r\n" + 
//			"	  , A.POLYN2 POLYN2\r\n" + 
//			"	  , A.OPRNUM OPRNUM\r\n" + 
//			"	  , A.WNAME1 WNAME1\r\n" + 
//			"	  , A.GETNAM GETNAM\r\n" + 
//			"	  , A.WIDNUM WIDNUM\r\n" + 
//			"	  , A.GETIDN GETIDN\r\n" + 
//			"	  , A.WLICNO WLICNO\r\n" + 
//			"	  , A.CRTDAT CRTDAT\r\n" + 
//			"	  , A.WINDAT WINDAT\r\n" + 
//			"	  , A.WEXDAT WEXDAT\r\n" + 
//			"	  , A.YENPRO YENPRO\r\n" + 
//			"	  , A.STATUS STATUS\r\n" + 
//			"	  , C.STMSG STMSG\r\n" + 
//			"	FROM\r\n" + 
//			"	  AXENTEMP A JOIN STATUS_MSG C\r\n" + 
//			"	    ON A.STATUS = C.STCODE AND A.MSGTYPE = C.MSGTYPE\r\n" + 
//			"		WHERE 1=1\r\n" + 
//			"		<if test=\"upddat_start != null\">\r\n" + 
//			"		AND A.UPDDAT &gt;= #{upddat_start,jdbcType=TIMESTAMP}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"upddat_end != null\">\r\n" + 
//			"		AND A.UPDDAT &lt;= #{upddat_end,jdbcType=TIMESTAMP}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"polyn1 != null and polyn1 != ''\">\r\n" + 
//			"		and A.POLYN1 = #{polyn1,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"polyn2 != null and polyn2 != ''\">\r\n" + 
//			"		and A.POLYN2 = #{polyn2,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"oprnum != null and oprnum != ''\">\r\n" + 
//			"		AND A.OPRNUM = #{oprnum,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"objeno != null\">\r\n" + 
//			"		and A.OBJENO = #{objeno,jdbcType=SMALLINT},\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"fcerno != null and fcerno != ''\">\r\n" + 
//			"		AND A.FCERNO = #{fcerno,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"applno != null and applno != ''\">\r\n" + 
//			"		AND A.APPLNO = #{applno,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"wlicno != null and wlicno != ''\">\r\n" + 
//			"		AND A.WLICNO = #{wlicno,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"widnum != null and widnum != ''\">\r\n" + 
//			"		AND A.WIDNUM = #{widnum,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"getidn != null and getidn != ''\">\r\n" + 
//			"		AND A.GETIDN = #{getidn,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" +
//			"		<if test=\"checkStatus == 1\">\r\n" + 
//			"		AND A.STATUS = '05'\r\n" + 
//			"		</if>\r\n" +
//			"		<if test=\"checkStatus == 2\">\r\n" + 
//			"		AND A.STATUS = '07'\r\n" + 
//			"		</if>\r\n" +
//			"		AND C.MSGTYPE = '0'" + "</script>")
//	List<PolicyChangeApplQueryTable> queryAxentempJoinTableCheck(@Param("upddat_start") Date upddat_start,
//			@Param("upddat_end") Date upddat_end, @Param("polyn1") String polyn1, @Param("polyn2") String polyn2, @Param("oprnum") String oprnum,
//			@Param("objeno") Short objeno, @Param("fcerno") String fcerno, @Param("applno") String applno,
//			@Param("wlicno") String wlicno, @Param("widnum") String widnum, @Param("getidn") String getidn, @Param("checkStatus") String checkStatus);
//	
//	@Select("<script>"+"SELECT\r\n" + 
//			"	  A.APPLNO APPLNO\r\n" + 
//			"	  , A.FCERNO POLYN2\r\n" + 
//			"	  , A.OPRNUM OPRNUM\r\n" + 
//			"	  , A.WNAMEI WNAME1\r\n" + 
//			"	  , A.GETNAM GETNAM\r\n" + 
//			"	  , A.WIDNUM WIDNUM\r\n" + 
//			"	  , A.GETIDN GETIDN\r\n" + 
//			"	  , A.WLICNO WLICNO\r\n" + 
//			"	  , A.WINDAT WINDAT\r\n" + 
//			"	  , A.WEXDAT WEXDAT\r\n" + 
//			"	  , A.YENPRO YENPRO\r\n" + 
//			"	  , A.ENVDAT ENVDAT\r\n" + 
//			"	  , A.STATUS STATUS\r\n" + 
//			"	  , C.STMSG STMSG\r\n" + 
//			"	FROM\r\n" + 
//			"	  AFENTEMP A JOIN STATUS_MSG C\r\n" + 
//			"	    ON A.STATUS = C.STCODE AND A.MSGTYPE = C.MSGTYPE\r\n" + 
//			"		WHERE 1=1\r\n" + 
//			"		<if test=\"upddat_start != null\">\r\n" + 
//			"		AND A.UPDDAT &gt;= #{upddat_start,jdbcType=TIMESTAMP}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"upddat_end != null\">\r\n" + 
//			"		AND A.UPDDAT &lt;= #{upddat_end,jdbcType=TIMESTAMP}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"fcerno != null and fcerno != ''\">\r\n" + 
//			"		AND A.FCERNO = #{fcerno,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"oprnum != null and oprnum != ''\">\r\n" + 
//			"		AND A.OPRNUM = #{oprnum,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"applno != null and applno != ''\">\r\n" + 
//			"		AND A.APPLNO = #{applno,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"wlicno != null and wlicno != ''\">\r\n" + 
//			"		AND A.WLICNO = #{wlicno,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"widnum != null and widnum != ''\">\r\n" + 
//			"		AND A.WIDNUM = #{widnum,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"getidn != null and getidn != ''\">\r\n" + 
//			"		AND A.GETIDN = #{getidn,jdbcType=CHAR}\r\n" + 
//			"		</if>" +
//			"		AND C.MSGTYPE = '0'" + "</script>")
//	List<PolicyChangeApplQueryTable> queryAfentempJoinTable(@Param("upddat_start") Date upddat_start,
//			@Param("upddat_end") Date upddat_end, @Param("fcerno") String fcerno, @Param("oprnum") String oprnum, @Param("applno") String applno,
//			@Param("wlicno") String wlicno, @Param("widnum") String widnum, @Param("getidn") String getidn);
//
//	@Select("<script>"+"SELECT\r\n" + 
//			"	  A.APPLNO APPLNO\r\n" + 
//			"	  , A.FCERNO POLYN2\r\n" + 
//			"	  , A.OPRNUM OPRNUM\r\n" + 
//			"	  , A.WNAMEI WNAME1\r\n" + 
//			"	  , A.GETNAM GETNAM\r\n" + 
//			"	  , A.WIDNUM WIDNUM\r\n" + 
//			"	  , A.GETIDN GETIDN\r\n" + 
//			"	  , A.WLICNO WLICNO\r\n" + 
//			"	  , A.CRTDAT CRTDAT\r\n" + 
//			"	  , A.WINDAT WINDAT\r\n" + 
//			"	  , A.WEXDAT WEXDAT\r\n" + 
//			"	  , A.YENPRO YENPRO\r\n" + 
//			"	  , A.STATUS STATUS\r\n" + 
//			"	  , C.STMSG STMSG\r\n" + 
//			"	FROM\r\n" + 
//			"	  AFENTEMP A JOIN STATUS_MSG C\r\n" + 
//			"	    ON A.STATUS = C.STCODE AND A.MSGTYPE = C.MSGTYPE\r\n" + 
//			"		WHERE 1=1\r\n" + 
//			"		<if test=\"upddat_start != null\">\r\n" + 
//			"		AND A.UPDDAT &gt;= #{upddat_start,jdbcType=TIMESTAMP}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"upddat_end != null\">\r\n" + 
//			"		AND A.UPDDAT &lt;= #{upddat_end,jdbcType=TIMESTAMP}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"fcerno != null and fcerno != ''\">\r\n" + 
//			"		AND A.FCERNO = #{fcerno,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"oprnum != null and oprnum != ''\">\r\n" + 
//			"		AND A.OPRNUM = #{oprnum,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"applno != null and applno != ''\">\r\n" + 
//			"		AND A.APPLNO = #{applno,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"wlicno != null and wlicno != ''\">\r\n" + 
//			"		AND A.WLICNO = #{wlicno,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"widnum != null and widnum != ''\">\r\n" + 
//			"		AND A.WIDNUM = #{widnum,jdbcType=CHAR}\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"getidn != null and getidn != ''\">\r\n" + 
//			"		AND A.GETIDN = #{getidn,jdbcType=CHAR}\r\n" + 
//			"		</if>" +
//			"		<if test=\"checkStatus == 1\">\r\n" + 
//			"		AND A.STATUS = '05'\r\n" + 
//			"		</if>\r\n" + 
//			"		<if test=\"checkStatus == 2\">\r\n" + 
//			"		AND A.STATUS = '07'\r\n" + 
//			"		</if>\r\n" + 
//			"		AND C.MSGTYPE = '0'" + "</script>")
//	List<PolicyChangeApplQueryTable> queryAfentempJoinTableCheck(@Param("upddat_start") Date upddat_start,
//			@Param("upddat_end") Date upddat_end, @Param("fcerno") String fcerno, @Param("oprnum") String oprnum, @Param("applno") String applno,
//			@Param("wlicno") String wlicno, @Param("widnum") String widnum, @Param("getidn") String getidn, @Param("checkStatus") String checkStatus);
//	
//	//批改申請書列印_批改查詢頁面用(強制)
//	@Select("<script>"
//			+ "SELECT "
//			+ "afen.APPLNO,WLICNO,WENGNO,WTYPVE,WMODVE,WPASUN, "
//			+ "WYMLIC,WYYPRO,WCCVOL,afen.YENDNO,WINDAT,afen.WEXDAT, "
//			+ "WTTPRE,ENVDAT,FCERNO,YENPRO,afen.POLYN1,WNAMEI,cus.GETNAM,afen.YENPRO "
//			+ "FROM "
//			+ "AFENTEMP afen "
//			+ "LEFT JOIN "
//			+ "custemp cus "
//			+ "ON "
//			+ "afen.applno = cus.applno "
//			+ "WHERE 1=1 "
//			+ "AND cus.change_type = 'f' "
//			+ "<if test='applno != null and applno != \"\"'> "
//			+ "AND afen.APPLNO = #{applno,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='fcerno != null and fcerno != \"\"'> "
//			+ "AND FCERNO = #{fcerno,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='yenpro != null and yenpro != \"\"'> "
//			+ "AND YENPRO = #{yenpro,jdbcType=CHAR} "
//			+ "</if> "
//			+ "</script>")
//	List<printTemp>selectAfenForPrint(@Param("applno") String applno, @Param("fcerno") String fcerno, @Param("yenpro") String yenpro);
//	
//	//批改申請書列印_批改查詢頁面用(任意)
//	@Select("<script>"
//			+ "SELECT "
//			+ "axen.APPLNO,WLICNO,WTYPVE,WMODVE,WPASUN,WCARNO, "
//			+ "WYMLIC,WYYPRO,WCCVOL,axen.YENDNO,WINDAT,axen.WEXDAT,WTTPRE, "
//			+ "ENVDAT,FCERNO,YENPRO,axen.POLYN1,POLYN2,WENGIN,WNAME1,cus.GETNAM "
//			+ "FROM "
//			+ "AXENTEMP axen "
//			+ "LEFT JOIN "
//			+ "custemp cus "
//			+ "ON "
//			+ "axen.applno = cus.applno	"
//			+ "WHERE "
//			+ "cus.change_type = 'h' "
//			+ "<if test='applno != null and applno != \"\"'> "
//			+ "AND axen.APPLNO = #{applno,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='polyn2 != null and polyn2 != \"\"'> "
//			+ "AND POLYN2 = #{polyn2,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='yenpro != null and yenpro != \"\"'> "
//			+ "AND YENPRO = #{yenpro,jdbcType=CHAR} "
//			+ "</if> "
//			+ "</script>")
//	List<printTemp>selectAxenForPrint(@Param("applno") String applno, @Param("polyn2") String polyn2, @Param("yenpro") String yenpro);
//	
//	//批改申請書列印_批改申請書列印頁面用(強制)
//	@Select("<script>"
//			+ "SELECT "
//			+ "* "
//			+ "FROM "
//			+ "AFENTEMP "
//			+ "WHERE 1=1 "
//			+ "<if test='fcerno != null and fcerno != \"\"'> "
//			+ "AND FCERNO = #{fcerno,jdbcType=CHAR} "
//			+ "</if> "
//			+ "ORDER BY "
//			+ "upddat "
//			+ "DESC LIMIT 1"
//			+ "</script>")
//	List<printTemp>selectAfenForPrint2(@Param("fcerno") String fcerno);
//	
//	//批改申請書列印_批改申請書列印頁面用(任意)
//	@Select("<script>"
//			+ "SELECT "
//			+ "* "
//			+ "FROM "
//			+ "AXENTEMP "
//			+ "WHERE 1=1 "
//			+ "<if test='polyn1 != null and polyn1 != \"\"'> "
//			+ "AND POLYN1 = #{polyn1,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='polyn2 != null and polyn2 != \"\"'> "
//			+ "AND POLYN2 = #{polyn2,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='objeno != null and objeno != \"\"'> "
//			+ "AND OBJENO = #{objeno,jdbcType=CHAR} "
//			+ "</if> "
//			+ "ORDER BY "
//			+ "upddat "
//			+ "DESC LIMIT 1"
//			+ "</script>")
//	List<printTemp>selectAxenForPrint2(@Param("polyn1") String polyn1, @Param("polyn2") String polyn2, @Param("objeno") short objeno);
//	
//	//批單及收據列印_查詢(強制)
//	@Select("<script>"
//			+ "SELECT "
//			+ "APPLNO,POLYN1,FCERNO POLYN2,YENDNO,WNAMEI WNAME1,GETNAM, "
//			+ "WLICNO,WTTPRE,BUILDMEM,BUILDDATE,PRTDAT,YRETIM PRTTIM,RECEIPTCOUNT, "
//			+ "YENPRO,ONAMEI oname1,OENGNO oengin,OLICNO,WINDAT,WEXDAT,OINDAT,OEXDAT "
//			+ "FROM "
//			+ "AFENTEMP "
//			+ "WHERE 1=1 "
//			+ "<if test='buildmem1 != null and buildmem1 != \"\"'> "
//			+ "AND BUILDMEM = #{buildmem1,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='polyn1_1 != null and polyn1_1 != \"\"'> "
//			+ "AND polyn1 = #{polyn1_1,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='yendno_start != null and yendno_start != \"\"'> "
//			+ "AND yendno &gt;= #{yendno_start,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='yendno_end != null and yendno_end != \"\"'> "
//			+ "AND yendno &lt;= #{yendno_end,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='applno_start != null and applno_start != \"\"'> "
//			+ "AND applno &gt;= #{applno_start,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='applno_end != null and applno_end != \"\"'> "
//			+ "AND applno &lt;= #{applno_end,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='builddate_start != null'> "
//			+ "AND builddate &gt;= #{builddate_start,jdbcType=TIMESTAMP} "
//			+ "</if> "
//			+ "<if test='builddate_end != null'> "
//			+ "AND builddate &lt;= #{builddate_end,jdbcType=TIMESTAMP} "
//			+ "</if> "
//			+ "<if test='polyn1_2 != null and polyn1_2 != \"\"'> "
//			+ "AND polyn1 = #{polyn1_2,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='buildmem2 != null and buildmem2 != \"\"'> "
//			+ "AND buildmem = #{buildmem2,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='polyn2 != null'> "
//			+ "AND fcerno = #{polyn2,jdbcType=TIMESTAMP} "
//			+ "</if> "
//			+ "</script>")
//	List<Axentemp>queryAfentempSelective(@Param("buildmem1") String buildmem1, @Param("polyn1_1") String polyn1_1,
//			@Param("yendno_start") String yendno_start, @Param("yendno_end") String yendno_end, @Param("applno_start") String applno_start,
//			@Param("applno_end") String applno_end, @Param("builddate_start") Date builddate_start,
//			@Param("builddate_end") Date builddate_end,@Param("polyn1_2") String polyn1_2, @Param("buildmem2") String buildmem2,
//			@Param("polyn2") String polyn2);
//	
//	//批單及收據列印_查詢(任意)
//	@Select("<script>"
//			+ "SELECT "
//			+ "APPLNO,POLYN1,POLYN2,OBJENO,YENDNO,WNAME1,GETNAM, "
//			+ "WLICNO,WTTPRE,BUILDMEM,BUILDDATE,PRTDAT,PRTTIM,RECEIPTCOUNT, "
//			+ "YENPRO,ONAME1,OENGIN,OLICNO,WINDAT,WEXDAT,OINDAT,OEXDAT  "
//			+ "FROM "
//			+ "AXENTEMP "
//			+ "WHERE 1=1 "
//			+ "<if test='buildmem1 != null and buildmem1 != \"\"'> "
//			+ "AND BUILDMEM = #{buildmem1,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='polyn1_1 != null and polyn1_1 != \"\"'> "
//			+ "AND polyn1 = #{polyn1_1,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='yendno_start != null and yendno_start != \"\"'> "
//			+ "AND yendno &gt;= #{yendno_start,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='yendno_end != null and yendno_end != \"\"'> "
//			+ "AND yendno &lt;= #{yendno_end,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='applno_start != null and applno_start != \"\"'> "
//			+ "AND applno &gt;= #{applno_start,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='applno_end != null and applno_end != \"\"'> "
//			+ "AND applno &lt;= #{applno_end,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='builddate_start != null'> "
//			+ "AND builddate &gt;= #{builddate_start,jdbcType=TIMESTAMP} "
//			+ "</if> "
//			+ "<if test='builddate_end != null'> "
//			+ "AND builddate &lt;= #{builddate_end,jdbcType=TIMESTAMP} "
//			+ "</if> "
//			+ "<if test='polyn1_2 != null and polyn1_2 != \"\"'> "
//			+ "AND polyn1 = #{polyn1_2,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='buildmem2 != null and buildmem2 != \"\"'> "
//			+ "AND buildmem = #{buildmem2,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='polyn2 != null'> "
//			+ "AND polyn2 = #{polyn2,jdbcType=TIMESTAMP} "
//			+ "</if> "
//			+ "</script>")
//	List<Axentemp>queryAxentempSelective(@Param("buildmem1") String buildmem1, @Param("polyn1_1") String polyn1_1,
//			@Param("yendno_start") String yendno_start, @Param("yendno_end") String yendno_end, @Param("applno_start") String applno_start,
//			@Param("applno_end") String applno_end, @Param("builddate_start") Date builddate_start,
//			@Param("builddate_end") Date builddate_end,@Param("polyn1_2") String polyn1_2, @Param("buildmem2") String buildmem2,
//			@Param("polyn2") String polyn2);
//	
//	// 保批單綜合查詢強制(保單&延伸檔)
//	@Select("<script>"
//			+ "SELECT "
//			+ "A.FCERNO POLYN2, A.WNAMEI WNAME1, A.WIDNUM, B.GETNAM, B.GETIDN, "
//			+ "A.WLICNO, A.WINDAT, A.WEXDAT, B.WINSRC INNSRC, B.WSOLNO SOLIN1, "
//			+ "B.BKCOD1, A.YRETIM PRTTIM, A.YENPRO "
//			+ "FROM AFENPF1 A JOIN CUSTPF1 B ON A.YENDNO = B.YENDNW "
//			+ "WHERE 1=1 "
//			+ "<if test='fcerno != null and fcerno != \"\"'> "
//			+ "AND A.FCERNO = #{fcerno,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='wlicno != null and wlicno != \"\"'> "
//			+ "AND A.WLICNO = #{wlicno,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test='wengin != null and wengin != \"\"'> "
//			+ "AND A.WENGNO = #{wengin,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test='widnum != null and widnum != \"\"'> "
//			+ "AND A.WIDNUM = #{widnum,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test='getidn != null and getidn != \"\"'> "
//			+ "AND B.GETIDN = #{getidn,jdbcType=CHAR} "
//			+ "</if>"
//			+ "</script>")
//	List<InsEndorseQueryTable> queryAfenpf1andCustpf1(@Param("fcerno") String fcerno, @Param("wlicno") String wlicno, 
//			@Param("wengin") String wengin, @Param("widnum") String widnum, @Param("getidn") String getidn);
//	
//	// 保批單綜合查詢任意(保單&延伸檔)
//	@Select("<script>"
//			+ "SELECT "
//			+ "A.POLYN2, A.WNAME1, A.WIDNUM, B.GETNAM, B.GETIDN, "
//			+ "A.WLICNO, A.WINDAT, A.WEXDAT, B.WINSRC INNSRC, B.WSOLNO SOLIN1, "
//			+ "B.BKCOD1, A.PRTTIM, A.YENPRO "
//			+ "FROM AXENPF1 A JOIN CUSTPF1 B ON A.YENDNO = B.YENDNW "
//			+ "WHERE 1=1 "
//			+ "<if test='polyn1 != null and polyn1 != \"\"'> "
//			+ "AND A.POLYN1 = #{polyn1,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='polyn2 != null and polyn2 != \"\"'> "
//			+ "AND A.POLYN2 = #{polyn2,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='objeno != null and objeno != \"\"'> "
//			+ "AND A.objeno = #{objeno,jdbcType=CHAR} "
//			+ "</if> "
//			+ "<if test='wlicno != null and wlicno != \"\"'> "
//			+ "AND A.WLICNO = #{wlicno,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test='wengin != null and wengin != \"\"'> "
//			+ "AND A.WENGIN = #{wengin,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test='widnum != null and widnum != \"\"'> "
//			+ "AND A.WIDNUM = #{widnum,jdbcType=CHAR} "
//			+ "</if>"
//			+ "<if test='getidn != null and getidn != \"\"'> "
//			+ "AND B.GETIDN = #{getidn,jdbcType=CHAR} "
//			+ "</if>"
//			+ "</script>")
//	List<InsEndorseQueryTable> queryAxenpf1andCustpf1(@Param("polyn1") String polyn1, @Param("polyn2") String polyn2, 
//			@Param("objeno") Short objeno, @Param("wlicno") String wlicno, @Param("wengin") String wengin, 
//			@Param("widnum") String widnum, @Param("getidn") String getidn);
//			
//	/**
//	 * 查詢主險下拉選資料
//	 * @param insid
//	 * @return
//	 */
//	@Select("<script>" + "select distinct a.inscode, a.instype, a.insid, a.insmain, b.consho" + 
//			"   from calculationview a join amcdpf1 b" + 
//			"   on a.inscode = b.concod" + 
//			"   where 1=1" + 
//			"<if test='insid != null and insid != \"\"'> " +
//			"   and a.insid = #{insid,jdbcType=CHAR} " + 
//			"</if> " +
//			"   and a.insmain = '1'" + 
//			"   and b.itmcod = '25'" +
//			"   order by a.inscode "+ "</script>")
//	List<MainInsuranceColumn> queryMainInsuranceSelList(@Param("insid") String insid);
//
//	/**
//	 * 查詢主險欄位資料
//	 * @param insid
//	 * @param inscode 
//	 * @return
//	 */
//	@Select("<script>" + "select a.instype, a.insid, a.insmain, a.inscode," + 
//			"   a.column1type, a.column1code, a.column2type," +
//			"   a.column2code, a.column3type, a.column3code," +
//			"   a.column4type, a.column4code, b.consho" +
//			"   from calculationview a join amcdpf1 b" + 
//			"   on a.inscode = b.concod" + 
//			"   where 1=1" + 
//			"<if test='insid != null and insid != \"\"'> " +
//			"   and a.insid = #{insid,jdbcType=CHAR} " + 
//			"</if> " +
//			"<if test='inscode != null and inscode != \"\"'> " +
//			"   and a.inscode = #{inscode,jdbcType=CHAR} " + 
//			"</if> " +
//			"   and a.insmain = '1'" + 
//			"   and b.itmcod = '25'" +
//			"   order by a.inscode "+ "</script>")
//	List<MainInsuranceColumn> queryMainInsuranceColumnList(@Param("insid") String insid, @Param("inscode") String inscode);
//	
//	/**
//	 * 查詢附險下拉選資料
//	 * @param insMaster
//	 * @return
//	 */
//	@Select("<script>" + "select a.ins_mapping insMapping, b.consho" + 
//			"   from ins_relation a join amcdpf1 b" + 
//			"   on a.ins_mapping = b.concod" + 
//			"   where 1=1" + 
//			"<if test='insMaster != null and insMaster != \"\"'> " +
//			"   and a.ins_master = #{insMaster,jdbcType=CHAR} " + 
//			"</if> " +
//			"   and a.rel_note = 'V'" + 
//			"   and b.itmcod = '25'" +
//			"   order by a.ins_mapping "+ "</script>")
//	List<SubInsurance> querySubInsuranceList(@Param("insMaster") String insMaster);
}