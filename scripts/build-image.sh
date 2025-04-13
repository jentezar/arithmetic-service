set -u 
: "$VERSION"

docker build -t ghcr.io/jentezar/arithmetic-service:$VERSION --file Dockerfile .