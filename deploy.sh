#!/bin/bash

# Thiết lập biến môi trường cho SSH agent (nếu cần)
eval $(ssh-agent -s)
ssh-add ~/.ssh/id_rsa
# Thông báo bắt đầu deploy
echo "Bắt đầu deploy ứng dụng..."

# Cập nhật code từ Git
echo "Fetch code mới từ repository Git..."
git fetch

echo "Pull code mới từ repository Git..."
git pull origin master

# Clean và build ứng dụng bằng Gradle (bỏ qua test để tiết kiệm thời gian)
echo "Clean và build dự án với Gradle..."
./gradlew clean build -x test

# Dừng và xóa container cũ (nếu có)
echo "Dừng và xóa container cũ (nếu có)..."
sudo docker stop application || true
sudo docker rm application || true

# Xây dựng lại Docker image
echo "Build lại Docker image..."
sudo docker build -t run_project_jenkins .

# Chạy container mới với cổng 9091
echo "Chạy Docker container với ứng dụng mới..."
sudo docker run -d -p 9091:9091 --name application run_project_jenkins

# Kiểm tra xem container đã chạy chưa
if [ "$(docker ps -q -f name=application)" ]; then
  echo "Ứng dụng đã được deploy thành công và chạy trên cổng 9091!"
else
  echo "Có lỗi xảy ra khi deploy ứng dụng!"
fi