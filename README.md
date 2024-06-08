# Flogo: A DSL for the Design and Lifecycle Management of Neural Networks
[![Skill Icons](https://skillicons.dev/icons?i=java,idea,py,pytorch,pycharm,git&perline=10)](https://skillicons.dev)

## Introduction

Flogo is a Domain-Specific Language (DSL) designed to simplify and automate the creation of neural networks. It aims to abstract the technical complexity of frameworks like PyTorch or TensorFlow, allowing developers to model both the structure of neural networks and their training process using a more intuitive and straightforward language. Additionally, it includes a code generator that transforms the model described with the DSL into Python code, accelerating the development and maintenance process.

## Table of Contents
1. [Overview](#overview)
    - [Key Concepts](#key-concepts)
        - [Laboratory](#laboratory)
        - [Architecture](#architecture)
2. [Installation](#installation)
3. [Examples](#examples)
    - [Multi-layer Perceptron](#multi-layer-perceptron)
    - [Convolutional Neural Network](#convolutional-neural-network)
    - [Recurrent Neural Network](#recurrent-neural-network)
4. [License](#license)
5. [Contact](#contact)
## Overview

Flogo simplifies the design and lifecycle management of neural networks through a DSL that focuses on two main aspects:
- **Design**: Configuring the architecture of the neural network, such as layers and activation functions.
- **Lifecycle Management**: Managing the lifecycle of the neural network, including its creation, training, and evaluation.

### Key Concepts

#### Laboratory

The Laboratory in Flogo is where the training of the neural network is defined. It specifies the parameters and configurations required for the training process, such as the number of epochs, optimizer, loss function, and dataset. The Laboratory also includes strategies for splitting the dataset into training, testing, and validation sets.

Example:
```dsl
Laboratory(epochs = 10, name = "MNIST EXAMPLE")
    Adam
    MAELoss
    ClassificationStrategy
    Dataset(name = "mnist_flatten.tsv", batchSize = 10)
        Split(train=0.7, test=0.2, validation=0.1)

    Experiment e626
        Materialization(vLayer="01") > ReLU

    Experiment e221
        MSELoss
        Materialization(vLayer="01") > Sigmoid
```
Experiments in Flogo are used to define different training runs with varying configurations. Each experiment can have different loss functions, optimizers or materializations to replace vLayers in the architecture. This approach allows for the comparison of different setups, helping to identify the optimal configuration for the neural network.

### Architecture
The Architecture defines the structure of the neural network. It specifies the types of layers, the number of units in each layer, and the activation functions. The architecture is organized into sections such as LinearSection, ConvolutionalSection, and RecurrentSection.

Example:
```dsl
Architecture LinearNeuralNetwork
    LinearSection
        Input(x=784)
        Block
            Linear > Output(x=200)
            VLayer(id="01")
        Block
            Linear > Output(x=84)
            VLayer(id="01")
        Block
            Linear > Output(x=10)
            Softmax
```


## Installation
1. **Install IntelliJ IDEA**:
    - If you don't already have IntelliJ IDEA installed, download and install it from the [JetBrains website](https://www.jetbrains.com/idea/download/).

2. **Install the Intino Plugin**:
    - Open IntelliJ IDEA.
    - Go to `File` > `Settings` (or `IntelliJ IDEA` > `Preferences` on macOS).
    - In the left-hand pane, select `Plugins`.
    - Click on the `Marketplace` tab and search for `Intino`.
    - Click `Install` to add the Intino plugin to your IDE.
    - Restart IntelliJ IDEA if prompted.

3. **Clone the Repository and Open the Project in IntelliJ IDEA**:
    - Open IntelliJ IDEA.
    - Select `File` > `New` > `Project from Version Control...`.
    - In the dialog that appears, enter the URL of the Flogo repository:
    - Click `Clone`.
    - IntelliJ IDEA will automatically clone the repository and open the project.

With these steps completed, you should have Flogo set up and ready to use in IntelliJ IDEA.

## Examples

### Multilayer Perceptron
A multilayer perceptron (MLP) is a name for a modern feedforward artificial neural network, consisting of fully connected neurons with a nonlinear activation function, organized in at least three layers, notable for being able to distinguish data that is not linearly separable.

Below is an example of a MLP defined using Flogo:

```dsl
Laboratory(epochs = 10, name = "MNIST EXAMPLE")
    Adam
    MAELoss
    ClassificationStrategy
    Dataset(name = "mnist_flatten.tsv", batchSize = 10)
        Split(train=0.7, test=0.2, validation=0.1)

    Experiment e626

Architecture LinearNeuralNetwork
    LinearSection
        Input(x=784)
        Block
            Linear > Output(x=200)
            ReLU
        Block
            Linear > Output(x=84)
            ReLU
        Block
            Linear > Output(x=10)
            Softmax
```

### Convolutional Neural Networks
A Convolutional Neural Network (CNN) is a type of deep learning model specifically designed for processing structured grid data, such as images. The primary building block of a CNN is the convolutional layer, which applies convolution operations to the input data using a set of filters to extract features. 

Below is an example of a CNN defined using Flogo:

```dsl
Laboratory(epochs = 10, name = "MNIST")
    Adam
    MAELoss
    ClassificationStrategy
    Dataset(name = "mnist.tsv", batchSize = 10)
        Split(train=0.7, test=0.2, validation=0.1)

    Experiment e626

Architecture ConvolutionalNeuralNetwork
    ConvolutionalSection
        Input(32, 32, 1)
        Block
            Convolutional > Output(28, 28, 6)
            ReLU
            MaxPool > Output(14, 14)
        Block
            Convolutional > Output(10, 10, 16)
            ReLU
            MaxPool > Output(5, 5)

    FlattenSection

    LinearSection
        Block
            Linear > Output(120)
            ReLU
        Block
            Linear > Output(84)
            ReLU
        Block
            Linear > Output(10)
            Softmax
```

### Recurrent Neural Network
A Recurrent Neural Network (RNN) is a class of neural networks designed for processing sequential data by maintaining a memory of previous inputs through recurrent connections. This allows RNNs to capture temporal dependencies and patterns in data sequences, making them suitable for tasks like time series prediction, language modeling, and speech recognition.

Below is an example of a RNN defined using Flogo:
```dsl
Laboratory(epochs=10, name="MNIST")
    Adam
    MAELoss
    ClassificationStrategy
    Dataset(name="mnist.csv", batchSize=10)
        Split(train=0.7, test=0.2, validation=0.1)

    Experiment e626

Architecture
    RecurrentSection
        Input(seqLength=28, x=28)
        Block
            LSTM(bidirectional=false, numLayers=4)
                EndSequence(reduce = flatten) > Output(x=512)
            ReLU
        Block
            Linear > Output(x=300)
            ReLU
        Block
            Linear > Output(x=75)
            ReLU
        Block
            Linear > Output(x=10)
            Softmax

```
## License
This project is licensed under the EUPL v1.2 License - see the [LICENSE](LICENSE.txt) file for details.


## Contact

(c) 2023 José Juan Hernández Gálvez 
<br>Github: https://github.com/josejuanhernandezgalvez<br> 
(c) 2023 Juan Carlos Santana Santana 
<br>Github: https://github.com/JuanCarss<br>
(c) 2023 Joel del Rosario Pérez
<br>Github: https://github.com/Joeel71<br>
