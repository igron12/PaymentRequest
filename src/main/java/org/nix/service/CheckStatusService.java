package org.nix.service;

import org.nix.RequestStatus;
import org.springframework.stereotype.Service;

@Service
public interface CheckStatusService {
    RequestStatus checkStatus(long identifier);
}
