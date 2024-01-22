#!/bin/sh

NAMESPACE="bk-ns"

while getopts ":idn:" opt; do
  case $opt in
    i) INSTALL=true ;;
    d) DELETE=true ;;
    n) NAMESPACE="$OPTARG" ;;
    \?) echo "Invalid option: -$OPTARG" >&2; exit 1 ;;
    :)  echo "Option -$OPTARG requires an argument." >&2; exit 1 ;;
  esac
done

shift $((OPTIND-1))

if [ "$INSTALL" = true ]; then
  kubectl create ns "$NAMESPACE"
  helm dependency update ./bk-base
  helm dependency update ./bk-supervision
  helm install bk-base ./bk-base -n "$NAMESPACE"
  helm install bk-supervision ./bk-supervision -n "$NAMESPACE"
elif [ "$DELETE" = true ]; then
  helm uninstall bk-base -n "$NAMESPACE"
  helm uninstall bk-supervision -n "$NAMESPACE"
else
  echo "Specify either -i for installation or -d for deletion."
  exit 1
fi
