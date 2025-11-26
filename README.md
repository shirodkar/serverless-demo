# Serverless Demo

This is a set of applications to demonstrate the features of Openshift Serverless.

## Prerequisites

- Openshift Container Platform 4.20

## Setup

1. Install Advanced Cluster Management for Kubernetes (ACM) Operator

**Note:** ACM is only used to install operators. Alternatively, you can install the following operators manually: 
  - Openshift Pipelines
  - Openshift Serverless
  - Openshift Serverless Logic
  - Custom Metrics Autoscaler
  - Openshift DevSpaces
  - Streams for Apache Kafka (install under project called 'kafka')
  - Streams for Apache Kafka Console (install under project called 'kafka-console')

2. Install Openshift GitOps (ArgoCD) Operator, and wait for the ArgoCD instance to be Available.
3. Make sure you are logged into the OCP cluster as a cluster admin.
4. Give ArgoCD access to the OCP cluster:

```oc adm policy add-cluster-role-to-user cluster-admin system:serviceaccount:openshift-gitops:openshift-gitops-argocd-application-controller --rolebinding-name gitops-role-binding```

## Install the required Operators and Demo Apps

1. ```git clone https://github.com/shirodkar/serverless-demo.git```
2. ```cd serverless-demo```
3. Make sure you are logged into the OCP cluster as a cluster admin.
4. If you are not using ACM, exclude the application-demo-acm.yaml file, by adding the following to gitops/app-of-apps/applications.yaml:
```spec.source.directory.exclude: '{application-demo-acm.yaml}'```
5. ```oc apply -f gitops/app-of-apps/applications.yaml```

**Note:** It could take about 10-20 minutes for the installation to complete. Wait until all apps in ArgoCD are Healthy and Synced.

6. From the ArgoCD UI, select the 'infra' tile => DETAILS => PARAMETERS, and EDIT the 'kafkaconsoleurl' parameter value using the base URI of your OCP cluster.

## Demo

1. Serving - [Recording](https://drive.google.com/file/d/1lIlwB2DTdQukK9pF7qbKo1QpqpGLEkU1/view?usp=drive_link)
2. Eventing - [Recording](https://drive.google.com/file/d/1Jqri669dx_2Z5T1hOGBCfxEuaU0k0dKZ/view?usp=drive_link)
3. Functions - [Recording](https://drive.google.com/file/d/1DnTBI78GySUXsp1YI0wOn86m0qdP14w2/view?usp=drive_link)
4. Sererless Logic - [Recording](https://drive.google.com/file/d/1y-2TyQVWyxn6IY7AgY3d29BePxcNMEy0/view?usp=drive_link)
