build:
	docker build -t car-dealership .
	
local-dev:
	docker-compose up

local-dev-down:
	docker-compose down