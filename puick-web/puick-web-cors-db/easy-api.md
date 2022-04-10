# 跨域控制层

跨域控制层


---
## 新增跨域规则

> BASIC

**Path:** /api/system/cors

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| allowedType | integer | 跨域内容属性 |
| allowedContent | string | 允许内容 |

**Request Demo:**

```json
{
  "allowedType": 0,
  "allowedContent": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 状态码 |
| message | string | 返回描述 |
| data | object | 内容 |
| state | boolean | 状态 |
| time | integer | 时间戳 |

**Response Demo:**

```json
{
  "code": 0,
  "message": "",
  "data": null,
  "state": false,
  "time": 0
}
```




---
## 删除跨域规则

> BASIC

**Path:** /api/system/cors

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array |  |
|  | integer |  |

**Request Demo:**

```json
[
  0
]
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 状态码 |
| message | string | 返回描述 |
| data | object | 内容 |
| state | boolean | 状态 |
| time | integer | 时间戳 |

**Response Demo:**

```json
{
  "code": 0,
  "message": "",
  "data": null,
  "state": false,
  "time": 0
}
```




---
## 查询跨域规则

> BASIC

**Path:** /api/system/cors/page

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| pageNum | integer | 当前页 |
| maxSize | integer | 每页数量 |
| query | object | 查询条件 |
| &ensp;&ensp;&#124;─allowedType | integer | 跨域内容属性 |
| &ensp;&ensp;&#124;─allowedContent | string | 允许内容 |
| orderItems | array | 排序条件 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─column | string | 需要进行排序的字段 |
| &ensp;&ensp;&ensp;&ensp;&#124;─asc | boolean | 是否正序排列，默认 true |

**Request Demo:**

```json
{
  "pageNum": 0,
  "maxSize": 0,
  "query": {
    "allowedType": 0,
    "allowedContent": ""
  },
  "orderItems": [
    {
      "column": "",
      "asc": false
    }
  ]
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 状态码 |
| message | string | 返回描述 |
| data | object | 内容 |
| &ensp;&ensp;&#124;─records | array | 查询数据列表 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─allowedType | integer | 允许的类型 0: origin 1: header 2: method |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─allowedContent | string | 允许的内容 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─creator | integer | 创建人ID |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─creationTime | string | 创建时间 |
| &ensp;&ensp;&#124;─total | integer | 总数 |
| &ensp;&ensp;&#124;─size | integer | 每页显示条数，默认 10 |
| &ensp;&ensp;&#124;─current | integer | 当前页 |
| &ensp;&ensp;&#124;─orders | array | 排序字段信息 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─column | string | 需要进行排序的字段 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─asc | boolean | 是否正序排列，默认 true |
| &ensp;&ensp;&#124;─optimizeCountSql | boolean | 自动优化 COUNT SQL |
| &ensp;&ensp;&#124;─searchCount | boolean | 是否进行 count 查询 |
| &ensp;&ensp;&#124;─optimizeJoinOfCountSql | boolean | {@link #optimizeJoinOfCountSql()} |
| &ensp;&ensp;&#124;─countId | string | countId |
| &ensp;&ensp;&#124;─maxLimit | integer | countId |
| state | boolean | 状态 |
| time | integer | 时间戳 |

**Response Demo:**

```json
{
  "code": 0,
  "message": "",
  "data": {
    "records": [
      {
        "id": 0,
        "allowedType": 0,
        "allowedContent": "",
        "creator": 0,
        "creationTime": ""
      }
    ],
    "total": 0,
    "size": 0,
    "current": 0,
    "orders": [
      {
        "column": "",
        "asc": false
      }
    ],
    "optimizeCountSql": false,
    "searchCount": false,
    "optimizeJoinOfCountSql": false,
    "countId": "",
    "maxLimit": 0
  },
  "state": false,
  "time": 0
}
```




---
## 重新加载跨域规则

> BASIC

**Path:** /api/system/cors/reload

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 状态码 |
| message | string | 返回描述 |
| data | object | 内容 |
| state | boolean | 状态 |
| time | integer | 时间戳 |

**Response Demo:**

```json
{
  "code": 0,
  "message": "",
  "data": null,
  "state": false,
  "time": 0
}
```



