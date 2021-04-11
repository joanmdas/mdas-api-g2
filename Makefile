.PONY: all build test clean

all: build

build:
	@./gradlew assemble --warning-mode all

clean:
	@./gradlew clean --warning-mode all

test:
	@./gradlew check --warning-mode all
