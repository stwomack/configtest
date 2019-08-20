# configtest

cf create-service p-config-server standard config-server -c '{"git": { "uri": "https://github.com/stwomack/womack-configrepo" } }'
