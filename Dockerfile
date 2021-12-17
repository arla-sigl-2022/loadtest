FROM mozilla/sbt:8u292_1.5.4

COPY ./ /code
WORKDIR /code

RUN sbt compile
