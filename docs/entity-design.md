# Entity 설계

## 1. Wish
### 목적
뜨고 싶은 작품을 저장하는 Entity
### 컬럼
컬럼      타입      설명
-----------------------
id      Long        PK
title       String      작품명
designer    String      제작자
patternUrls     List<String>        도안 URL 목록
originalYarn        YarnInfo        원작 실
originalNeedleSize        BigDecimal      원작 바늘
originalGaugeStitchCount       BigDecimal      원작 10cm 기준 코수
originalGaugeRowCount     BigDecimal      원작 10cm 기준 단수
memo        String      메모
### 관계
- Wish N : 1 YarnInfo


## 2. YarnInfo
### 목적
실 제품 자체의 정보를 저장하는 Entity이다.
실제 보유 여부와 관계없이 원작 실, 관심 실 등의 기준 정보를 관리한다.
### 컬럼
컬럼      타입      설명
-----------------------
id      Long      PK
brand       String      브랜드
name        String      실 제품명
season      String      계절
yarnType        String      실 종류
thickness       String      실 두께
lengthPer100g       Integer      100g당 길이(m)
memo        String      메모
### 관계
- YarnInfo 1 : N YarnColor


## 3. YarnColor
### 목적
실 제품의 색상 정보를 저장하는 Entity이다.
### 컬럼
컬럼      타입      설명
-----------------------
id		Long		PK
yarnInfo	YarnInfo	실 제품
colorCode	String		색상 코드
colorName	String		색상명
memo		String		메모
### 관계
- YarnInfo 1 : N YarnColor


## 4. YarnStock
### 목적
사용자가 실제로 보유한 실의 입고, 사용, 조정 기록을 관리하는 Entity이다.
재고는 특정 실 제품과 해당 실의 색상 조합을 기준으로 관리한다.
### 컬럼
컬럼      타입      설명
-----------------------
id		Long		PK
yarnInfo	YarnInfo	실 제품 정보
yarnColor	YarnColor	실 색상 정보
stockType	YarnStockType	재고 변동 유형
gram	BigDecimal	변동 g
memo		String		메모
createdAt	LocalDateTime	등록일시
### 관계
- YarnStock N : 1 YarnInfo
- YarnStock N : 1 YarnColor
### 제약 조건
- YarnStock의 yarnColor는 반드시 연결된 yarnInfo에 속한 색상이어야 한다.


## 5. KnittingProject
### 목적
실제로 진행하는 뜨개 작품을 프로젝트 단위로 관리하는 Entity이다.
### 컬럼
컬럼      타입      설명
-----------------------
id		Long		PK
wish		Wish		Wish에서 시작한 경우 원본 Wish
title		String		작품명
status		ProjectStatus		상태
designer	String		제작자
patternUrls	List<String>	도안 URL 목록
originalYarn	YarnInfo	원작 실
originalNeedleSize	BigDecimal	원작 바늘(mm)
originalGaugeStitchCount	BigDecimal	원작 10cm 기준 코수
originalGaugeRowCount	BigDecimal	원작 10cm 기준 단수
usedYarnInfo	YarnInfo	사용 실 제품
usedYarnColor	YarnColor	사용 실 색상
usedNeedle	Needle	사용 바늘
gauge		Gauge		사용 게이지
castOnCount	Integer		CO 코수
startedAt	LocalDate	시작일
finishedAt	LocalDate	완성일
memo		String		메모
createdAt	LocalDateTime	등록일시
updatedAt	LocalDateTime	수정일시
### 관계
- KnittingProject N : 1 Wish
- KnittingProject N : 1 Gauge
- KnittingProject N : 1 YarnInfo
- KnittingProject N : 1 YarnColor
- KnittingProject N : 1 Needle
- KnittingProject 1 : N KnittingLog


## ProjectStatus
### 목적
작품 진행 상태를 정의한다.
### 항목
값      설명
-----------------------
CO		시작
WIP		진행 중
HOLD		중단/보류
FO		완성


## 6. KnittingLog
### 목적
하나의 KnittingProject에 대한 진행 기록을 블로그 형식으로 저장하는 Entity이다.
### 컬럼
컬럼      타입      설명
-----------------------
id		Long		PK
knittingProject	KnittingProject	진행 중 작품
content		String		진행 코멘트
changes		String		변경사항
imageUrls	List<String>	진행 기록 사진 URL 목록
createdAt	LocalDateTime	작성일시
updatedAt	LocalDateTime	수정일시
### 관계
- KnittingLog N : 1 KnittingProject


## 7. Gauge
### 목적
실과 바늘 조합에 따른 사용자 게이지를 저장하고, 도안 게이지와 비교하여 변환 계산에 활용하는 Entity이다.
### 컬럼
컬럼      타입      설명
-----------------------
id		Long		PK
yarnInfo	YarnInfo	실 제품
yarnColor	YarnColor	실 색상
needle		Needle		사용 바늘
stitchCount	BigDecimal	10cm 기준 코수
rowCount	BigDecimal	10cm 기준 단수
memo		String		메모
createdAt	LocalDateTime	등록일시
updatedAt	LocalDateTime	수정일시
### 관계
- Gauge N : 1 YarnInfo
- Gauge N : 1 YarnColor
- Gauge N : 1 Needle


## 8. Needle
### 목적
사용자가 보유한 바늘 정보를 관리하는 Entity이다.
### 컬럼
컬럼      타입      설명
-----------------------
id		Long		PK
brand		String		브랜드
needleType	String		바늘 종류
sizeMm		BigDecimal	바늘 호수(mm)
lengthCm	Integer		바늘 길이(cm)
memo		String		메모
createdAt	LocalDateTime	등록일시
updatedAt	LocalDateTime	수정일시
### 관계
- Needle 1 : N Gauge
- Needle 1 : N KnittingProject


## 9. NeedleCable
### 목적
사용자가 보유한 케이블 정보를 관리하는 Entity이다.
### 컬럼
컬럼      타입      설명
-----------------------
id		Long		PK
brand		String		브랜드
cableType	String		케이블 종류
lengthCm	Integer		케이블 길이(cm)
memo		String		메모
createdAt	LocalDateTime	등록일시
updatedAt	LocalDateTime	수정일시
