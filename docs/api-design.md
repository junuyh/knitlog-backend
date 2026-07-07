# API 설계

## 1. Wish API

### 1.1 Wish 등록
POST /api/wishes

#### Request
필드		타입		필수		설명
-------------------------------
title		String		Y		작품명
designer	String		N		제작자
patternUrls	List<String>	N		도안 URL 목록
originalYarnId	Long		N		원작 실 ID
originalNeedleSize	BigDecimal	N		원작 바늘(mm)
originalGaugeStitchCount	BigDecimal	N		원작 10cm 기준 코수
originalGaugeRowCount	BigDecimal	N		원작 10cm 기준 단수
memo		String		N		메모

#### Response
필드		타입		설명
----------------------------
id		Long		Wish ID
title		String		작품명
designer	String		제작자
patternUrls	List<String>	도안 URL 목록
originalYarnId	Long		원작 실 ID
originalNeedleSize	BigDecimal	원작 바늘(mm)
originalGaugeStitchCount	BigDecimal	원작 10cm 기준 코수
originalGaugeRowCount	BigDecimal	원작 10cm 기준 단수
memo		String		메모
createdAt	LocalDateTime	등록일시
updatedAt	LocalDateTime	수정일시



### 1.2 Wish 목록 조회
GET /api/wishes

#### Query Parameter
필드		타입		필수		설명
----------------------------
keyword		String		N		작품명/제작자 검색어
page		Integer		N		페이지 번호
size		Integer		N		페이지 크기

#### Response
필드		타입		설명
----------------------------
content		List<WishResponse>	Wish 목록
page		Integer		현재 페이지
size		Integer		페이지 크기
totalElements	Long		전체 개수
totalPages	Integer		전체 페이지 수


### 1.3 Wish 상세 조회
GET /api/wishes/{wishId}

#### Path Variable
필드		타입		설명
----------------------------
wishId		Long		Wish ID

#### Response
필드		타입		설명
----------------------------
id		Long		Wish ID
title		String		작품명
designer	String		제작자
patternUrls	List<String>	도안 URL 목록
originalYarnId	Long		원작 실 ID
originalNeedleSize	BigDecimal	원작 바늘(mm)
originalGaugeStitchCount	BigDecimal	원작 10cm 기준 코수
originalGaugeRowCount	BigDecimal	원작 10cm 기준 단수
memo		String		메모
createdAt	LocalDateTime	등록일시
updatedAt	LocalDateTime	수정일시


### 1.4 Wish 수정
PUT /api/wishes/{wishId}

#### Path Variable
필드		타입		설명
----------------------------
wishId		Long		Wish ID

#### Request
필드		타입		필수		설명
----------------------------
title		String		Y		작품명
designer	String		N		제작자
patternUrls	List<String>	N		도안 URL 목록
originalYarnId	Long		N		원작 실 ID
originalNeedleSize	BigDecimal	N		원작 바늘(mm)
originalGaugeStitchCount	BigDecimal	N		원작 10cm 기준 코수
originalGaugeRowCount	BigDecimal	N		원작 10cm 기준 단수
memo		String		N		메모

#### Response
필드		타입		설명
----------------------------
id		Long		Wish ID
title		String		작품명
designer	String		제작자
patternUrls	List<String>	도안 URL 목록
originalYarnId	Long		원작 실 ID
originalNeedleSize	BigDecimal	원작 바늘(mm)
originalGaugeStitchCount	BigDecimal	원작 10cm 기준 코수
originalGaugeRowCount	BigDecimal	원작 10cm 기준 단수
memo		String		메모
createdAt	LocalDateTime	등록일시
updatedAt	LocalDateTime	수정일시


### 1.5 Wish 삭제
DELETE /api/wishes/{wishId}

#### Path Variable
필드		타입		설명
----------------------------
wishId		Long		Wish ID

#### Response
204 No Content