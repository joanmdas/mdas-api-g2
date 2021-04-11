.PONY: all build test clean

all: clean build

build:
	@./gradlew build --warning-mode all

clean:
	@./gradlew clean --warning-mode all

test:
	@./gradlew check --warning-mode all
