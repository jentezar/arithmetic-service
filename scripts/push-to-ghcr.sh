set -u
: "$VERSION"

echo ${{secrets.ACCESS_TOKEN}} | docker login ghcr.io -u jentezar --password-stdin
docker push ghcr.io/jentezar/arithmetic-service:$VERSION