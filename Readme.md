## cashback-api

## Results of tests

	1. Teste #1

```
register-transaction

{
  "id": 1,
  "transaction_code": "df638fc3-90b8-4b70-964a-04f5f1400ba7",
  "user_cpf": "11111111111",
  "user_name": "João Primeiro",
  "user_balance": 12.3,
  "transaction_date": "2017/01/13 20:51:54",
  "transaction_type": "TP_2"
}

```
```
users 

[
  {
    "user_id": 1,
    "user_cpf": "11111111111",
    "user_balance": 12.3,
    "user_name": "João Primeiro"
  },
  {
    "user_id": 2,
    "user_cpf": "22222222222",
    "user_balance": 52.02,
    "user_name": "Maria Segunda"
  },
  {
    "user_id": 3,
    "user_cpf": "33333333333",
    "user_balance": 2.25,
    "user_name": "Emerson Terceiro"
  },
  {
    "user_id": 4,
    "user_cpf": "44444444444",
    "user_balance": 89.66,
    "user_name": "Mario Quarto"
  }
]
```

```
users-transactions

[
  {
    "id": 1,
    "transaction_code": "df638fc3-90b8-4b70-964a-04f5f1400ba7",
    "user_cpf": "11111111111",
    "user_name": "João Primeiro",
    "user_balance": 12.3,
    "transaction_date": "2017/01/13 20:51:54",
    "transaction_type": "TP_2"
  }
]

```

	2. Teste #2

```
register-transaction

{
  "id": 2,
  "transaction_code": "f30a5c08-d27c-4de0-ac0d-da8dc9061747",
  "user_cpf": "22222222222",
  "user_name": "Maria Segunda",
  "user_balance": 52.92,
  "transaction_date": "2017/01/13 21:01:54",
  "transaction_type": "TP_3"
}
```

```
users

[
  {
    "user_id": 1,
    "user_cpf": "11111111111",
    "user_balance": 12.3,
    "user_name": "João Primeiro"
  },
  {
    "user_id": 2,
    "user_cpf": "22222222222",
    "user_balance": 52.92,
    "user_name": "Maria Segunda"
  },
  {
    "user_id": 3,
    "user_cpf": "33333333333",
    "user_balance": 2.25,
    "user_name": "Emerson Terceiro"
  },
  {
    "user_id": 4,
    "user_cpf": "44444444444",
    "user_balance": 89.66,
    "user_name": "Mario Quarto"
  }
]
```

```
users-transactions

[
  {
    "id": 1,
    "transaction_code": "df638fc3-90b8-4b70-964a-04f5f1400ba7",
    "user_cpf": "11111111111",
    "user_name": "João Primeiro",
    "user_balance": 12.3,
    "transaction_date": "2017/01/13 20:51:54",
    "transaction_type": "TP_2"
  },
  {
    "id": 2,
    "transaction_code": "f30a5c08-d27c-4de0-ac0d-da8dc9061747",
    "user_cpf": "22222222222",
    "user_name": "Maria Segunda",
    "user_balance": 52.92,
    "transaction_date": "2017/01/13 21:01:54",
    "transaction_type": "TP_3"
  }
]
```

	3. Teste #3	

```
register-transaction

{
  "id": 3,
  "transaction_code": "b00b106c-4cfd-41ac-af12-8929a455c413",
  "user_cpf": "22222222222",
  "user_name": "Maria Segunda",
  "user_balance": 53.82,
  "transaction_date": "2017/01/13 21:04:22",
  "transaction_type": "TP_3"
}
```

```
users
[
  {
    "user_id": 1,
    "user_cpf": "11111111111",
    "user_balance": 12.3,
    "user_name": "João Primeiro"
  },
  {
    "user_id": 2,
    "user_cpf": "22222222222",
    "user_balance": 53.82,
    "user_name": "Maria Segunda"
  },
  {
    "user_id": 3,
    "user_cpf": "33333333333",
    "user_balance": 2.25,
    "user_name": "Emerson Terceiro"
  },
  {
    "user_id": 4,
    "user_cpf": "44444444444",
    "user_balance": 89.66,
    "user_name": "Mario Quarto"
  }
]

```

```
users-transactions
[
  {
    "id": 1,
    "transaction_code": "df638fc3-90b8-4b70-964a-04f5f1400ba7",
    "user_cpf": "11111111111",
    "user_name": "João Primeiro",
    "user_balance": 12.3,
    "transaction_date": "2017/01/13 20:51:54",
    "transaction_type": "TP_2"
  },
  {
    "id": 2,
    "transaction_code": "f30a5c08-d27c-4de0-ac0d-da8dc9061747",
    "user_cpf": "22222222222",
    "user_name": "Maria Segunda",
    "user_balance": 52.92,
    "transaction_date": "2017/01/13 21:01:54",
    "transaction_type": "TP_3"
  },
  {
    "id": 3,
    "transaction_code": "b00b106c-4cfd-41ac-af12-8929a455c413",
    "user_cpf": "22222222222",
    "user_name": "Maria Segunda",
    "user_balance": 53.82,
    "transaction_date": "2017/01/13 21:04:22",
    "transaction_type": "TP_3"
  }
]
```
	4. Teste #4

```
register-transaction
400 - bad request (Because user don't have enough money on your balance)
```

```	
users
[
  {
    "user_id": 1,
    "user_cpf": "11111111111",
    "user_balance": 12.3,
    "user_name": "João Primeiro"
  },
  {
    "user_id": 2,
    "user_cpf": "22222222222",
    "user_balance": 53.82,
    "user_name": "Maria Segunda"
  },
  {
    "user_id": 3,
    "user_cpf": "33333333333",
    "user_balance": 2.25,
    "user_name": "Emerson Terceiro"
  },
  {
    "user_id": 4,
    "user_cpf": "44444444444",
    "user_balance": 89.66,
    "user_name": "Mario Quarto"
  }
]
```

```
users-transactions
[
  {
    "user_id": 1,
    "user_cpf": "11111111111",
    "user_balance": 12.3,
    "user_name": "João Primeiro"
  },
  {
    "user_id": 2,
    "user_cpf": "22222222222",
    "user_balance": 53.82,
    "user_name": "Maria Segunda"
  },
  {
    "user_id": 3,
    "user_cpf": "33333333333",
    "user_balance": 2.25,
    "user_name": "Emerson Terceiro"
  },
  {
    "user_id": 4,
    "user_cpf": "44444444444",
    "user_balance": 89.66,
    "user_name": "Mario Quarto"
  }
]
```

## Lincense
[MIT License](http://rflpazini.mit-license.org) :copyright: Rafael Pazinis
