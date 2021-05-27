How To Use
=============

## About Setting

- 요구사항에 맞게 Denormalizing/Masking 할 규칙들을 tagging_rule.json 파일에서 on/off 설정.

    - (전화번호, 주소, 비밀번호 등 Denormalizing, Masking을 위한 정규식)

- raw_pattern_unit.json, denorm_pattern_unit.json 은 1, 2차 태깅에 필요한 태깅 정규식으로 요구사항과 관련 X

- 규칙 추가 시 사전에 json form과 같은 형태로...


### Denormalizing On/Off

- 요구사항 or 기능 문제로 사용하지 않은 규칙들은 tagging_rule.json 에서 해당 규칙의 use 키를 off

- use 키의 값들은 소문자.

    - 설정할 규칙들은 각 규칙들의 첫번째 키인 "use" 키로 지정.
        
        - 사용 on : "use": "true"
        
        - 사용 off : "use": "false"
        
        
### Masking On/Off
        
- 요구사항에 의해 Denormalizing을 하지만 Masking을 하지 않은 경우 tagging_rule.json 에서 해당 규칙의 mask 키를 off

- mask 키의 값들은 소문자.

    - 설정할 규칙들은 각 규칙들의 두번째 키인 "mask" 키로 지정.
        
        - 사용 on : "mask": "true"
        
        - 사용 off : "mask": "false"


### On/Off Example

- 사용법

    - NumberTaggin Rule -> [tagging_rule.json](http://git.si.local/asr_platform/eznlp/blob/master/rules_tagger/tagging_rule.json)
       
        - 1 단계 : tagging_rule.json 열기
        
        - 2 단계 : 수정할 룰의 첫번째 "use" 키
        
        - 3 단계 : 아래 사용 가능한 Rule들을 "use" 키 값으로 설정.
        
            - 사용 O : "use": "true"
            
            - 사용 X : "use": "false"

        - 4 단계 : 마스킹할 Rule 들을 "mask" 키 값으로 설정.
        
            - 마스킹 O : "mask": "true"
            
            - 마스킹 X : "mask": "false"
            
            - 단, "use" 키의 값이 "false" 이면 "mask" 키가 "true" 라도 마스킹 x
                           
        - 5 단계 : tagging_rule.json 파일 저장.
       
        - Example : URL 룰 사용안하고 자동차번호를 Denormalzing, Masking하고 전화번호는 Denormalzing만 사용
            
            ```json
            [
                {
                  "use": "false",
                  "mask": "false",
                  "url": [
                    {
                      "name": "url",
                      "tag": "(?<DOMAIN2b>{{DOMAIN2b}}+)(?<DOMAIN1b>{{DOMAIN1b}})"
                    }
                  ]
                },
                {
                  "use": "true",
                  "mask": "true",
                  "car_id": [
                    {
                      "name": "car_id1",
                      "tag": "(?<LEFT>(자동차 *번호|차량 *번호|번호판|차 *번호){{NOTAG_0_75}}{{BOUNDARY}})(?<N1>{{NUM012345}}{2,3}{{BOUNDARY_ALLOW}})(?<D1>( *에)?{{BOUNDARY}}?)(?<CARNCODE>{{CAR_NCODE}}{{BOUNDARY_ALLOW}})(?<N4>{{NUM012}}{4})"
                    },
                    {
                      "name": "car_id4",
                      "tag": "(?<LEFT>(자동차 *번호|차량 *번호|번호판|차 *번호){{NOTAG_0_75}}{{BOUNDARY}})(?<N4>{{NUM012}}{4})"
                    },
                    {
                      "name": "car_id5",
                      "tag": "(?<LEFT>{{BOUNDARY}})(?<N1>{{NUM012345}}{2,3}{{BOUNDARY_ALLOW}})(?<D1>( *에)?{{BOUNDARY}}?)(?<CARNCODE>{{CAR_NCODE}}{{BOUNDARY_ALLOW}})(?<N4>{{NUM012}}{4})(?<RIGHT>.{0,30}(차량|차주|차종))"
                    }
                  ]
                },
                {
                  "use": "true",
                  "mask": "false",
                  "tel": [
                    {
                      "name": "tel1",
                      "tag": "(?<LEFT>(팩스|전화|연락처|휴대폰|핸드폰|폰 *번호)({{NOTAG_0_75}}({{TAG}}{{NOTAG_0_25}})*?){{BOUNDARY}})(?<N1>{{TEL_HEAD}})(?<D1>{{DASH}}*)(?<N2>{{NUM012}}{3,4})(?<D2>{{DASH}}*)(?<N3>{{NUM012}}{4})"
                    },
                    {
                      "name": "tel2",
                      "tag": "(?<LEFT>(팩스|전화|연락처|휴대폰|핸드폰|폰 *번호)({{NOTAG_0_75}}({{TAG}}{{NOTAG_0_25}})*?){{BOUNDARY}})(?<N1>{{TEL_HEAD}})(?<D1>{{DASH}}*)(?<N2>{{NUM012}}{3,4})(?<D2>{{DASH}}*)(?<N3>{{NUM012}}*)"
                    }
                  ]
                }
            ]
            ```

    - Raw Pattern Unit -> [raw_pattern_unit.json](http://git.si.local/asr_platform/eznlp/blob/master/rules_tagger/raw_pattern_unit.json)
        
        - 1 단계 : raw_pattern_unit.json 열기
        
        - 2 단계 : 수정할 룰의 첫번째 "tag" 키
        
        - 3 단계 : 아래 사용 가능한 Rule들을 "tag" 키값으로 설정.
        
            - 사용 O : "use": "true"
            
            - 사용 X : "use": "false"
            
        - 4 단계 : raw_pattern_unit.json 파일 저장하기 끝.
        
        - Example
        
            ```json
            [
              {
                "use": "true",
                "TAGS": [
                  {
                    "name": "TAG",
                    "tag": "<[^>]*?>"
                  }
                ]
              },
              {
                "use": "true",
                "NOTAGS": [
                  {
                    "name": "NOTAG",
                    "tag": "[^<>=*]"
                  },
                  {
                    "name": "NOTAG_0_75",
                    "tag": "{{NOTAG}}{0,75}?"
                  }
                ]
              },
              {
                "use": "true",
                "BOUNDARYS": [
                  {
                    "name": "BOUNDARY",
                    "tag": "(^|[ \t\r\n])+?"
                  },
                  {
                    "name": "BOUNDARY_ALLOW",
                    "tag": "(^|[ \t\r\n])*?"
                  }
                ]
              }
            ]
            ```

    - Denormalizing Rule -> [denorm_rule.json](http://git.si.local/asr_platform/eznlp/blob/master/rules_tagger/denorm_rule.json)
        
        - 1 단계 : denorm_rule.json 열기
        
        - 2 단계 : 수정할 룰의 첫번째 "tag" 키
        
        - 3 단계 : 아래 사용 가능한 Rule들을 "tag" 키 값으로 설정.
        
            - 사용 O : "use": "true"
            
            - 사용 X : "use": "false"
                        
        - 4 단계 : denorm_rule.json 파일 저장하기 끝.
        
        - Example
        
            ```json
            [
              {
                "use": "true",
                "alphabet": [
                  {
                    "name": "alphabet",
                    "tag": "(?<A0>지 *메일|네이버|다음|한 *메일|핫 *메일|점|쩜|닷|넷|컴|{{ENG1}})"
                  }
                ]
              },
              {
                "use": "true",
                "number": [
                  {
                    "name": "dash",
                    "tag": "(?<DASH> *(다시|에) *)"
                  },
                  {
                    "name": "number2",
                    "tag": "(?<N4>{{NUM6}}?)(?<W1> *)(?<N3>{{NUM5}}?)(?<W2> *)(?<N2>({{NUM4}}|{{NUM7}}))(?<W3> *)(?<N1>{{NUM012x}}?)"
                  }
                ]
              },
              {
                "use": "true",
                "symbol": [
                  {
                    "name": "atsign",
                    "tag": "(?<S0>골뱅이|[^ ]* *할 *때|{{CHAR_OF}})"
                  }
                ]
              }
            ]

            ```           
---