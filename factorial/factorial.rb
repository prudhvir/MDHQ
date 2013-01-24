def factorial(n)
  if n == 0
   1
  else
   n * factorial(n - 1)
  end
end

if ARGV[0].to_i.to_s == ARGV[0] and ARGV[0].to_i > 0
  puts factorial(ARGV[0].to_i)
else
  puts "Input is Invalid - Input should be an integer > 0"
end
