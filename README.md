# SPE RESOURCE ALLOCATION 2020
Paying homage to an old internship project I made around Aug 2019. SPE Resource Allocation was an internal project assigned to me. All data is classified under an NDA I signed, however you can see the format and the types of data (not the ACTUAL data) that we keep. 

## Usage
In all iterations, all methods require the following request headers:
```
Authentication = [String]
```
Additionally, they all return an `x-trace-id` as a response header for logging purposes:
```
x-trace-id = [String]
```
(work in progress for the time being)
### GET Methods
#### `/troops` mapping
`GET (host)/api/troops/positions`
returns:
```
[
	{ 
		"position_id":"0",
		"position_name":"position name 0"
	},
	{
		"position_id":"1",
		"position_name":"position name 1"
	},
	{
		"position_id":"2",
		"position_name":"position name 2"
	}
]
```
`GET (host)/api/troops/grades`
returns: 
```
[
	{ 
		"grade_id":"0",
		"grade_romawi:"II/1",
		"grade_name":"F"
	},
	{ 
		"grade_id":"1",
		"grade_romawi:"II/2",
		"grade_name":"N"
	},
	{ 
		"grade_id":"2",
		"grade_romawi:"II/3",
		"grade_name":"G"
	}
]
```
### POST Methods
