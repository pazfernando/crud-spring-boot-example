provider "aws" {
  region     = var.region
  access_key = var.access_key
  secret_key = var.secret_key
}

resource "null_resource" "deploy_docker" {
  provisioner "remote-exec" {
    inline = [
      "sudo docker login -u ${var.docker_user} -p ${var.docker_password} ${var.docker_registry}",
      "sudo docker pull ${var.docker_registry}/${var.docker_image}:latest",
      "random_port=$(shuf -i 10000-65535 -n 1)",
      "sudo docker run -d -p $random_port:8080 ${var.docker_registry}/${var.docker_image}:latest",
      "echo $random_port > /tmp/deployed_port"
    ]

    connection {
      type        = "ssh"
      user        = "ec2-user"
      private_key = file(var.private_key_path)
      host        = var.instance_ip
    }
  }
}

variable "region" {
  description = "AWS region"
  default     = "us-west-2"
}

variable "access_key" {
  description = "AWS access key"
}

variable "secret_key" {
  description = "AWS secret key"
}

variable "private_key_path" {
  description = "Path to the private key for SSH"
}

variable "docker_user" {
  description = "Docker registry user"
}

variable "docker_password" {
  description = "Docker registry password"
}

variable "docker_registry" {
  description = "Docker registry URL"
  default     = "registry.gitlab.com"
}

variable "docker_image" {
  description = "Docker image name"
}

variable "instance_ip" {
  description = "IP address of the existing EC2 instance"
}
