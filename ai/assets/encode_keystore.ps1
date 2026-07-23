$bytes = [IO.File]::ReadAllBytes('c:\Projects\skilonline\skil-release-key.jks')
$b64 = [Convert]::ToBase64String($bytes)
[IO.File]::WriteAllText('c:\Projects\skilonline\ai\assets\keystore_base64.txt', $b64)
Write-Host "Keystore base64 length: $($b64.Length)"
Write-Host "First 80 chars: $($b64.Substring(0, 80))"
Write-Host "Last 40 chars: $($b64.Substring($b64.Length - 40))"
