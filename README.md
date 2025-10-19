# java-calculator-precourse

## 기능 요구 사항

입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

### 기본 구분자
- 쉼표(`,`) 또는 콜론(`:`)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
- 예시:
  - `""` => `0`
  - `"1,2"` => `3`
  - `"1,2,3"` => `6`
  - `"1,2:3"` => `6`

### 커스텀 구분자
- 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다.
- 커스텀 구분자는 문자열 앞부분의 `"//"`와 `"\n"` 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
- 예시: `"//;\n1;2;3"`과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(`;`)이며, 결과 값은 `6`이 반환되어야 한다.

### 예외 처리
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 요구사항 구체화
#### 커스텀 구분자
- 문자열 앞부분의 `"//"`와 `"\n"` 사이에 위치하는 **문자**로 정의
- 따라서 문자열은 배제하고 단일 문자만 지원
- 커스텀 구분자와 기본 구분자 동시 사용 가능

#### 입력 검증
- 구분자와 **양수**로 구성된 문자열이므로 음수값, 0, 띄어쓰기 예외처리

---

## 입출력 요구 사항

### 입력
- 구분자와 양수로 구성된 문자열

### 출력
- 덧셈 결과
```
결과 : 6
```

## 실행 결과 예시

```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

---

## 프로젝트 구조

```
calculator/
├── Application.java (Main)
├── controller/
│   └── CalculatorController.java
├── service/
│   ├── CalculatorService.java (Interface)
│   └── CalculatorServiceImpl.java
├── model/
│   ├── parser/
│   │   ├── Parser.java (Interface)
│   │   └── DelimiterParser.java
│   └── calculator/
│       ├── Calculator.java (Interface)
│       └── PositiveNumberCalculator.java
├── view/
│   ├── input/
│   │   └── InputView.java
│   ├── output/
│   │   └── OutputView.java
│   └── validator/
│       └── InputValidator.java
└── common/
    └── ErrorMessages.java
```

### 레이어별 역할

#### View Layer
- **책임**: 사용자와의 입출력 인터페이스
- **InputView**: Console을 통한 사용자 입력
- **OutputView**: 계산 결과 및 에러 메시지 출력
- **InputValidator**: 입력값의 기본 형식 검증 (공백 체크)

#### Controller Layer
- **책임**: 애플리케이션 흐름 제어
- **CalculatorController**: View에서 입력을 받아 Service를 호출하고 결과를 View로 전달

#### ⚙️ Service Layer
- **책임**: 비즈니스 로직 조율 및 데이터 변환
- **CalculatorService**: Parser와 Calculator를 조합하여 문자열 입력을 계산 결과 문자열로 변환
- 데이터 흐름: `문자열 → 숫자 리스트 → 합계 → 문자열`

#### 🧮 Model Layer
- **책임**: 핵심 비즈니스 로직
- **Parser**: 구분자 기반 문자열 파싱 (기본 구분자: `,` `:` / 커스텀 구분자: `//;\n`)
- **Calculator**: 숫자 리스트 합산 및 양수 검증 (0 이하 값 예외 처리)

#### 🔧 Common
- **책임**: 공통 상수 및 유틸리티
- **ErrorMessages**: 애플리케이션 전역 에러 메시지 상수 관리

---

## 구현 기능 목록

### 1. View Layer
- [x] **InputView**: 사용자 입력 받기
- [x] **OutputView**: 결과 출력
- [x] **InputValidator**: 입력 검증 (공백 체크)

### 2. Controller Layer
- [x] **CalculatorController**: View ↔ Service 연결 및 흐름 제어

### 3. Service Layer
- [x] **CalculatorService**: model들을 조합하여 계산 수행

### 4. Model Layer
- [x] **Parser**: 문자열을 숫자 리스트로 파싱 (기본/커스텀 구분자 처리)
- [x] **Calculator**: 숫자 리스트 합산

### 5. Common
- [x] **ErrorMessages**: 에러 메시지 관리

### 6. Test
- [x] **ApplicationTest**: 통합 테스트
- [x] **ParserTest**: 파싱 단위 테스트
- [x] **CalculatorTest**: 계산 단위 테스트
- [x] **InputValidatorTest**: 입력 검증 단위 테스트

---

## 시나리오

```
1. 사용자 입력 (InputView)
   ↓
2. 입력 검증 (InputValidator)
   ↓
3. 계산 요청 (CalculatorController → CalculatorService)
   ↓
4. 문자열 파싱 (DelimiterParser)
   "1,2:3" → [1, 2, 3]
   ↓
5. 숫자 합산 (PositiveNumberCalculator)
   [1, 2, 3] → 6
   ↓
6. 결과 출력 (OutputView)
   "결과 : 6"
```

---