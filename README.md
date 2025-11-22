# Serverless Demo

This is a set of applications to demonstrate the features of Openshift Serverless.

## Prerequisites

- Openshift Container Platform 4.20

## Setup

1. Install Advanced Cluster Management for Kubernetes (ACM) Operator
2. Install Openshift GitOps (ArgoCD) Operator
3. Give ArgoCD access to the OCP cluster:

```oc adm policy add-cluster-role-to-user cluster-admin system:serviceaccount:openshift-gitops:openshift-gitops-argocd-application-controller --rolebinding-name gitops-role-binding```

## Install the required Operators and Demo Apps

1. ```git clone https://github.com/shirodkar/serverless-demo.git```
2. ```cd serverless-demo```
3. Make sure you are logged into the OCP cluster as a cluster admin.
4. ```oc apply -f gitops/app-of-apps/applications.yaml```

**Note:** It could take about 10-20 minutes for the installation to complete. Wait until all apps in ArgoCD are Healthy and Synced.

TBD: The Kafka Console hostname is hardcoded in gitops/platform/infra/templates/kafka-instances/console.yaml. Replace it with your hostname.